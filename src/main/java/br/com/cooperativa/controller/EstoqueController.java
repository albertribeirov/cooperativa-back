package br.com.cooperativa.controller;

import br.com.cooperativa.dto.EstoqueDTO;
import br.com.cooperativa.model.Estoque;
import br.com.cooperativa.service.EstoqueService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estoque")
@CrossOrigin("localhost:3000")
public class EstoqueController {

    private final EstoqueService estoqueService ;

    public EstoqueController(EstoqueService estoqueService) {
        this.estoqueService = estoqueService;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Estoque>> getAll() {
        return estoqueService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estoque> getEstoque(@PathVariable Long id){
        return estoqueService.findById(id);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Estoque> createEstoque(@RequestBody EstoqueDTO estoqueForm) {
        return estoqueService.save(estoqueForm.dtoToEstoque());
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Estoque> updateEstoque(@PathVariable Long id, @RequestBody EstoqueDTO estoqueForm) {
        return estoqueService.updateById(id, estoqueForm.dtoToEstoque());
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Estoque> deleteEstoque(@PathVariable Long id) {
        return estoqueService.deleteById(id);
    }
}