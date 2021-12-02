package br.com.cooperativa.controller;

import br.com.cooperativa.model.MovimentacaoEstoque;
import br.com.cooperativa.service.MovimentacaoEstoqueService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimentacaoestoque")
@CrossOrigin("localhost:3000")
public class MovimentacaoEstoqueController {

    private final MovimentacaoEstoqueService movimentacaoEstoqueService;

    public MovimentacaoEstoqueController(MovimentacaoEstoqueService movimentacaoEstoqueService) {
        this.movimentacaoEstoqueService = movimentacaoEstoqueService;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<MovimentacaoEstoque>> getAll() {
        return movimentacaoEstoqueService.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<MovimentacaoEstoque> getMovimentacao(@PathVariable Long id){
        return movimentacaoEstoqueService.findById(id);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<MovimentacaoEstoque> createmovimentacaoEstoque(@RequestBody MovimentacaoEstoque movimentacaoEstoqueForm) {
        return movimentacaoEstoqueService.save(movimentacaoEstoqueForm);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<MovimentacaoEstoque> updatemovimentacaoEstoque(@PathVariable Long id, @RequestBody MovimentacaoEstoque movimentacaoEstoqueForm) {
        return movimentacaoEstoqueService.updateById(id, movimentacaoEstoqueForm);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<MovimentacaoEstoque> deletemovimentacaoEstoque(@PathVariable Long id) {
        return movimentacaoEstoqueService.deleteById(id);
    }
}