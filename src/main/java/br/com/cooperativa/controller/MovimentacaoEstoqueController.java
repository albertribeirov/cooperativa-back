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

    @GetMapping("/todos")
    @ResponseBody
    public ResponseEntity<List<MovimentacaoEstoque>> getAll() {
        return movimentacaoEstoqueService.findAll();
    }

    @PostMapping("/salvar")
    @ResponseBody
    public ResponseEntity<MovimentacaoEstoque> createmovimentacaoEstoque(@RequestBody MovimentacaoEstoque movimentacaoEstoqueForm) {
        return movimentacaoEstoqueService.save(movimentacaoEstoqueForm);
    }

    @PutMapping("/atualizar")
    @ResponseBody
    public ResponseEntity<MovimentacaoEstoque> updatemovimentacaoEstoque(@RequestParam Long id, @RequestBody MovimentacaoEstoque movimentacaoEstoqueForm) {
        return movimentacaoEstoqueService.updateById(id, movimentacaoEstoqueForm);
    }

    @DeleteMapping("/deletar")
    @ResponseBody
    public ResponseEntity<MovimentacaoEstoque> deletemovimentacaoEstoque(@RequestParam Long id) {
        return movimentacaoEstoqueService.deleteById(id);
    }
}