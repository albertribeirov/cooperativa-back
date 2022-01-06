package br.com.cooperativa.controller;


import br.com.cooperativa.dto.ClienteDTO;
import br.com.cooperativa.model.Cliente;
import br.com.cooperativa.service.ClienteService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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
    public ResponseEntity<Page<Cliente>> getAll(Pageable pageable) {
        return clienteService.findAll(pageable);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Cliente> getCliente(@PathVariable Long id) {
        return clienteService.findById(id);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Cliente> createCliente(@RequestBody @Valid ClienteDTO clienteForm) {
        return clienteService.save(clienteForm.dtoToCliente());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable Long id, @RequestBody @Valid ClienteDTO clienteForm) {
        return clienteService.updateByID(id, clienteForm.dtoToCliente());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> deleteCliente(@PathVariable Long id) {
        return clienteService.deleteByID(id);
    }
}
