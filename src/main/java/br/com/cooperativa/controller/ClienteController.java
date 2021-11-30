package br.com.cooperativa.controller;


import br.com.cooperativa.model.Cliente;
import br.com.cooperativa.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
@CrossOrigin("localhost:3000")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> getCliente() {
        return clienteRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente clienteForm) {
        Cliente cliente = clienteRepository.save(clienteForm);
        return ResponseEntity.ok(cliente);
    }

    @PutMapping
    public ResponseEntity<Cliente> updateCliente(@PathParam("id") Long id, @RequestBody Cliente clienteForm) {
        Optional<Cliente> clienteFromDb = clienteRepository.findById(id);

        if (clienteFromDb.isPresent()) {
            Cliente cliente = clienteRepository.save(clienteFromDb.get());
            return ResponseEntity.ok(cliente);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteCliente(@PathParam("id") Long id) {
        Optional<Cliente> clienteFromDb = clienteRepository.findById(id);

        if (clienteFromDb.isPresent()) {
            clienteRepository.delete(clienteFromDb.get());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}