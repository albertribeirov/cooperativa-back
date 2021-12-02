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

    @GetMapping("/todos")
    @ResponseBody
    public ResponseEntity<List<Cliente>> getAll() {
        return clienteService.findAll();
    }

    @GetMapping("/buscar")
    @ResponseBody
    public ResponseEntity<Cliente> getCliente(@RequestParam Long id) {
        return clienteService.findById(id);
    }


    @PostMapping("/salvar")
    @ResponseBody
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente clienteForm) {
        return clienteService.save(clienteForm);
    }

    @PutMapping("/atualizar")
    public ResponseEntity<Cliente> updateCliente(@RequestParam Long id, @RequestBody Cliente clienteForm) {
        return clienteService.updateByID(id, clienteForm);
    }

    @DeleteMapping("/deletar")
    public ResponseEntity<Cliente> deleteCliente(@RequestParam Long id) {
        return clienteService.deleteByID(id);
    }
}
