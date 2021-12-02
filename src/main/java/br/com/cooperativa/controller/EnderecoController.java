package br.com.cooperativa.controller;

import br.com.cooperativa.model.Endereco;
import br.com.cooperativa.service.EnderecoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/endereco")
@CrossOrigin("localhost:3000")
public class EnderecoController {

    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Endereco>> getAll() {
        return enderecoService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Endereco> getEndereco(@PathVariable Long id){
        return enderecoService.findById(id);
    }


    @PostMapping
    @ResponseBody
    public ResponseEntity<Endereco> createEndereco(@RequestBody Endereco enderecoForm) {
        return enderecoService.save(enderecoForm);
    }


    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Endereco> updateEndereco(@PathVariable Long id, @RequestBody Endereco enderecoForm) {
        return enderecoService.updateById(id, enderecoForm);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Endereco> deleteEndereco(@PathVariable Long id) {
        return enderecoService.deleteById(id);
    }
}