package br.com.cooperativa.controller;

import br.com.cooperativa.dto.MaterialDTO;
import br.com.cooperativa.model.Material;
import br.com.cooperativa.service.MaterialService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/material")
@CrossOrigin("localhost:3000")
public class MaterialController {

    private final MaterialService materialService;

    public MaterialController(MaterialService materialService) {
        this.materialService = materialService;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Material>> getAll() {
        return materialService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Material> getMaterial(@PathVariable Long id){
        return materialService.findById(id);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Material> createMaterial(@RequestBody MaterialDTO materialForm) {
        return materialService.save(materialForm.dtoToMaterial());
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Material> updateMaterial(@PathVariable Long id, @RequestBody MaterialDTO materialForm) {
        return materialService.updateById(id, materialForm.dtoToMaterial());
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Material> deleteMaterial(@PathVariable Long id) {
        return materialService.deleteById(id);
    }
}