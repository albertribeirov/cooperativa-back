package br.com.cooperativa.service;

import br.com.cooperativa.model.MovimentacaoEstoque;
import br.com.cooperativa.repository.MovimentacaoEstoqueRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MovimentacaoEstoqueService {

    private final MovimentacaoEstoqueRepository movimentacaoEstoqueRepository;

    public MovimentacaoEstoqueService(MovimentacaoEstoqueRepository movimentacaoEstoqueRepository) {
        this.movimentacaoEstoqueRepository = movimentacaoEstoqueRepository;
    }

    @Transactional
    public ResponseEntity<MovimentacaoEstoque> save(MovimentacaoEstoque movimentacaoEstoque){
        movimentacaoEstoqueRepository.save(movimentacaoEstoque);
        return ResponseEntity.ok().build();
    }
}
