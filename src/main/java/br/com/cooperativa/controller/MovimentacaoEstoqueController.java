package br.com.cooperativa.controller;

import br.com.cooperativa.model.MovimentacaoEstoque;
import br.com.cooperativa.repository.MovimentacaoEstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movimentacaoestoque")
@CrossOrigin("localhost:3000")
public class MovimentacaoEstoqueController {

    @Autowired
    private MovimentacaoEstoqueRepository movimentacaoEstoqueRepository;

    @GetMapping
    public List<MovimentacaoEstoque> getmovimentacaoEstoque() {
        return movimentacaoEstoqueRepository.findAll();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<MovimentacaoEstoque> createmovimentacaoEstoque(@RequestBody MovimentacaoEstoque movimentacaoEstoqueForm) {
        MovimentacaoEstoque movimentacaoEstoque = movimentacaoEstoqueRepository.save(movimentacaoEstoqueForm);
        return ResponseEntity.ok(movimentacaoEstoque);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<MovimentacaoEstoque> updatemovimentacaoEstoque(@PathParam("id") Long id, @RequestBody MovimentacaoEstoque movimentacaoEstoqueForm) {
        Optional<MovimentacaoEstoque> movimentacaoEstoqueFromDb = movimentacaoEstoqueRepository.findById(id);

        if (movimentacaoEstoqueFromDb.isPresent()) {
            MovimentacaoEstoque movimentacaoEstoque = movimentacaoEstoqueRepository.save(movimentacaoEstoqueFromDb.get());
            return ResponseEntity.ok(movimentacaoEstoque);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity<Object> deletemovimentacaoEstoque(@PathParam("id") Long id) {
        Optional<MovimentacaoEstoque> movimentacaoEstoqueFromDb = movimentacaoEstoqueRepository.findById(id);

        if (movimentacaoEstoqueFromDb.isPresent()) {
            movimentacaoEstoqueRepository.delete(movimentacaoEstoqueFromDb.get());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}