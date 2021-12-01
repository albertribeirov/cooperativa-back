package br.com.cooperativa.service;

import br.com.cooperativa.model.MovimentacaoEstoque;
import br.com.cooperativa.repository.MovimentacaoEstoqueRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MovimentacaoEstoqueService {

    private final MovimentacaoEstoqueRepository movimentacaoEstoqueRepository;

    public MovimentacaoEstoqueService(MovimentacaoEstoqueRepository movimentacaoEstoqueRepository) {
        this.movimentacaoEstoqueRepository = movimentacaoEstoqueRepository;
    }

    @Transactional
    public ResponseEntity<MovimentacaoEstoque> save(MovimentacaoEstoque movimentacaoEstoque) {
        movimentacaoEstoqueRepository.save(movimentacaoEstoque);
        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<MovimentacaoEstoque> deleteById(Number id) {
        if(!movimentacaoEstoqueRepository.existsById((Long) id)){
            return ResponseEntity.notFound().build();
        }
        movimentacaoEstoqueRepository.deleteById((Long) id);
        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<MovimentacaoEstoque> updateById(Number id, MovimentacaoEstoque mv){
        if(!movimentacaoEstoqueRepository.existsById((Long) id)){
            return ResponseEntity.notFound().build();
        }
        mv.setId((Long) id);
        MovimentacaoEstoque mvAtt = movimentacaoEstoqueRepository.save(mv);
        return ResponseEntity.ok(mvAtt);
    }

    public ResponseEntity<List<MovimentacaoEstoque>> findAll(){
        List<MovimentacaoEstoque> movimentacaoEstoques = movimentacaoEstoqueRepository.findAll();
        return ResponseEntity.ok(movimentacaoEstoques);
    }

}
