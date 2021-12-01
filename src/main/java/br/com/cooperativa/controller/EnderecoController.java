package br.com.cooperativa.controller;

import br.com.cooperativa.model.Endereco;
import br.com.cooperativa.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/endereco")
@CrossOrigin("localhost:3000")
public class EnderecoController {

    @Autowired
    private EnderecoRepository cooperadoRepository;

    @GetMapping
    public List<Endereco> getEndereco() {
        return cooperadoRepository.findAll();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Endereco> createEndereco(@RequestBody Endereco cooperadoForm) {
        Endereco endereco = cooperadoRepository.save(cooperadoForm);
        return ResponseEntity.ok(endereco);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<Endereco> updateEndereco(@PathParam("id") Long id, @RequestBody Endereco cooperadoForm) {
        Optional<Endereco> enderecoFromDb = cooperadoRepository.findById(id);

        if (enderecoFromDb.isPresent()) {
            Endereco endereco = cooperadoRepository.save(enderecoFromDb.get());
            return ResponseEntity.ok(endereco);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity<Object> deleteEndereco(@PathParam("id") Long id) {
        Optional<Endereco> enderecoFromDb = cooperadoRepository.findById(id);

        if (enderecoFromDb.isPresent()) {
            cooperadoRepository.delete(enderecoFromDb.get());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}