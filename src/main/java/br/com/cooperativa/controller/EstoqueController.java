package br.com.cooperativa.controller;

import br.com.cooperativa.model.Estoque;
import br.com.cooperativa.repository.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estoque")
@CrossOrigin("localhost:3000")
public class EstoqueController {

    @Autowired
    private EstoqueRepository estoqueRepository;

    @GetMapping
    public List<Estoque> getEstoque() {
        return estoqueRepository.findAll();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Estoque> createEstoque(@RequestBody Estoque estoqueForm) {
        Estoque estoque = estoqueRepository.save(estoqueForm);
        return ResponseEntity.ok(estoque);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<Estoque> updateEstoque(@PathParam("id") Long id, @RequestBody Estoque estoqueForm) {
        Optional<Estoque> estoqueFromDb = estoqueRepository.findById(id);

        if (estoqueFromDb.isPresent()) {
            Estoque estoque = estoqueRepository.save(estoqueFromDb.get());
            return ResponseEntity.ok(estoque);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity<Object> deleteEstoque(@PathParam("id") Long id) {
        Optional<Estoque> estoqueFromDb = estoqueRepository.findById(id);

        if (estoqueFromDb.isPresent()) {
            estoqueRepository.delete(estoqueFromDb.get());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}