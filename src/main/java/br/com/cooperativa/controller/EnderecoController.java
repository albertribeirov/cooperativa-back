package br.com.cooperativa.controller;

import br.com.cooperativa.dto.EnderecoDTO;
import br.com.cooperativa.model.Endereco;
import br.com.cooperativa.service.EnderecoService;
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
    public ResponseEntity<Endereco> createEndereco(@RequestBody EnderecoDTO enderecoForm) {
        return enderecoService.save(enderecoForm.dtoToEndereco());
    }


    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Endereco> updateEndereco(@PathVariable Long id, @RequestBody EnderecoDTO enderecoForm) {
        return enderecoService.updateById(id, enderecoForm.dtoToEndereco());
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Endereco> deleteEndereco(@PathVariable Long id) {
        return enderecoService.deleteById(id);
    }
}