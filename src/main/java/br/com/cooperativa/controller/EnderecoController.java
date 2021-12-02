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

    @GetMapping("/todos")
    @ResponseBody
    public ResponseEntity<List<Endereco>> getAll() {
        return enderecoService.findAll();
    }

    @GetMapping("/buscar")
    @ResponseBody
    public ResponseEntity<Endereco> getEndereco(Long id){
        return enderecoService.findById(id);
    }

    @PostMapping("/salvar")
    @ResponseBody
    public ResponseEntity<Endereco> createEndereco(@RequestBody Endereco enderecoForm) {
        return enderecoService.save(enderecoForm);
    }

    @PutMapping("/atualizar")
    @ResponseBody
    public ResponseEntity<Endereco> updateEndereco(@RequestParam Long id, @RequestBody Endereco enderecoForm) {
        return enderecoService.updateById(id, enderecoForm);
    }

    @DeleteMapping
    @ResponseBody
    public ResponseEntity<Endereco> deleteEndereco(@RequestParam Long id) {
        return enderecoService.deleteById(id);
    }
}