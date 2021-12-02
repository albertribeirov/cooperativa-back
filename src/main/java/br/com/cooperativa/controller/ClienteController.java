package br.com.cooperativa.controller;


import br.com.cooperativa.model.Cliente;
import br.com.cooperativa.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
@CrossOrigin("localhost:3000")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Cliente>> getAll() {
        return clienteService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Cliente> getCliente(@PathVariable Long id) {
        return clienteService.findById(id);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente clienteForm) {
        return clienteService.save(clienteForm);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable Long id, @RequestBody Cliente clienteForm) {
        return clienteService.updateByID(id, clienteForm);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> deleteCliente(@PathVariable Long id) {
        return clienteService.deleteByID(id);
    }
}
