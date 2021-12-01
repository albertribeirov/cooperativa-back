package br.com.cooperativa.controller;

import br.com.cooperativa.model.Material;
import br.com.cooperativa.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/material")
@CrossOrigin("localhost:3000")
public class MaterialController {

    @Autowired
    private MaterialRepository materialRepository;

    @GetMapping
    public List<Material> getMaterial() {
        return materialRepository.findAll();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Material> createMaterial(@RequestBody Material materialForm) {
        Material estoque = materialRepository.save(materialForm);
        return ResponseEntity.ok(estoque);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<Material> updateMaterial(@PathParam("id") Long id, @RequestBody Material materialForm) {
        Optional<Material> materialFromDb = materialRepository.findById(id);

        if (materialFromDb.isPresent()) {
            Material estoque = materialRepository.save(materialFromDb.get());
            return ResponseEntity.ok(estoque);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity<Object> deleteMaterial(@PathParam("id") Long id) {
        Optional<Material> materialFromDb = materialRepository.findById(id);

        if (materialFromDb.isPresent()) {
            materialRepository.delete(materialFromDb.get());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}