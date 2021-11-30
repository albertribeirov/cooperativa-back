package br.com.cooperativa.controller;

import br.com.cooperativa.model.Cooperado;
import br.com.cooperativa.repository.CooperadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cooperado")
@CrossOrigin("localhost:3000")
public class CooperadoController {

    @Autowired
    private CooperadoRepository cooperadoRepository;

    @GetMapping
    public List<Cooperado> getCooperado() {
        return cooperadoRepository.findAll();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Cooperado> createCooperado(@RequestBody Cooperado cooperadoForm) {
        Cooperado cliente = cooperadoRepository.save(cooperadoForm);
        return ResponseEntity.ok(cliente);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<Cooperado> updateCooperado(@PathParam("id") Long id, @RequestBody Cooperado cooperadoForm) {
        Optional<Cooperado> clienteFromDb = cooperadoRepository.findById(id);

        if (clienteFromDb.isPresent()) {
            Cooperado cliente = cooperadoRepository.save(clienteFromDb.get());
            return ResponseEntity.ok(cliente);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity<Object> deleteCooperado(@PathParam("id") Long id) {
        Optional<Cooperado> clienteFromDb = cooperadoRepository.findById(id);

        if (clienteFromDb.isPresent()) {
            cooperadoRepository.delete(clienteFromDb.get());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}