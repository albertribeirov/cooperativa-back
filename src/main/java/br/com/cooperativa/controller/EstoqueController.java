package br.com.cooperativa.controller;

import br.com.cooperativa.dto.EstoqueDTO;
import br.com.cooperativa.model.Estoque;
import br.com.cooperativa.service.EstoqueService;
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

import java.util.List;

@RestController
@RequestMapping("/estoque")
@CrossOrigin("localhost:3000")
public class EstoqueController {

    private final EstoqueService estoqueService;

    public EstoqueController(EstoqueService estoqueService) {
        this.estoqueService = estoqueService;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<Page<Estoque>> getAll(Pageable pageable) {
        return estoqueService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estoque> getEstoque(@PathVariable Long id) {
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

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<List<Estoque>> listarEstoqueOrderByTipoMaterialAndMaterial() {
        return estoqueService.listarEstoqueOrderByTipoMaterialAndMaterial();
    }
}