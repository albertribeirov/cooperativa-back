package br.com.cooperativa.controller;

import br.com.cooperativa.model.DetalhamentoVenda;
import br.com.cooperativa.repository.DetalhamentoVendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/detalhamentovenda")
@CrossOrigin("localhost:3000")
public class DetalhamentoVendaController {

    @Autowired
    private DetalhamentoVendaRepository detalhamentoVendaRepository;

    @GetMapping
    public List<DetalhamentoVenda> getDetalhamentoVenda() {
        return detalhamentoVendaRepository.findAll();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhamentoVenda> createDetalhamentoVenda(@RequestBody DetalhamentoVenda cooperadoForm) {
        DetalhamentoVenda detalhamentoVenda = detalhamentoVendaRepository.save(cooperadoForm);
        return ResponseEntity.ok(detalhamentoVenda);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DetalhamentoVenda> updateDetalhamentoVenda(@PathParam("id") Long id, @RequestBody DetalhamentoVenda cooperadoForm) {
        Optional<DetalhamentoVenda> detalhamentoVendaFromDb = detalhamentoVendaRepository.findById(id);

        if (detalhamentoVendaFromDb.isPresent()) {
            DetalhamentoVenda detalhamentoVenda = detalhamentoVendaRepository.save(detalhamentoVendaFromDb.get());
            return ResponseEntity.ok(detalhamentoVenda);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity<Object> deleteDetalhamentoVenda(@PathParam("id") Long id) {
        Optional<DetalhamentoVenda> detalhamentoVendaFromDb = detalhamentoVendaRepository.findById(id);

        if (detalhamentoVendaFromDb.isPresent()) {
            detalhamentoVendaRepository.delete(detalhamentoVendaFromDb.get());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}