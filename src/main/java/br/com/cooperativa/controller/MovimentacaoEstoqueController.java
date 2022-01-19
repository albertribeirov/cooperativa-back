package br.com.cooperativa.controller;

import br.com.cooperativa.dto.MovimentacaoEstoqueDTO;
import br.com.cooperativa.model.MovimentacaoEstoque;
import br.com.cooperativa.service.MovimentacaoEstoqueService;
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
    public ResponseEntity<Page<MovimentacaoEstoque>> getAll(Pageable pageable) {
        return movimentacaoEstoqueService.findAll(pageable);
    }


    @GetMapping("/{id}")
    public ResponseEntity<MovimentacaoEstoque> getMovimentacao(@PathVariable Long id){
        return movimentacaoEstoqueService.findById(id);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<MovimentacaoEstoque> createmovimentacaoEstoque(@RequestBody MovimentacaoEstoqueDTO movimentacaoEstoqueForm) {
        return movimentacaoEstoqueService.save(movimentacaoEstoqueForm.dtoToMovimentacaoEstoque());
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<MovimentacaoEstoque> updatemovimentacaoEstoque(@PathVariable Long id, @RequestBody MovimentacaoEstoqueDTO movimentacaoEstoqueForm) {
        return movimentacaoEstoqueService.updateById(id, movimentacaoEstoqueForm.dtoToMovimentacaoEstoque());
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<MovimentacaoEstoque> deletemovimentacaoEstoque(@PathVariable Long id) {
        return movimentacaoEstoqueService.deleteById(id);
    }
}