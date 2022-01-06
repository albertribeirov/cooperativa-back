package br.com.cooperativa.service;

import br.com.cooperativa.model.MovimentacaoEstoque;
import br.com.cooperativa.repository.MovimentacaoEstoqueRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MovimentacaoEstoqueService {

    //Logger to easy debug
    private static final Logger logger = LoggerFactory.getLogger(ClienteService.class);

    private final MovimentacaoEstoqueRepository movimentacaoEstoqueRepository;

    public MovimentacaoEstoqueService(MovimentacaoEstoqueRepository movimentacaoEstoqueRepository) {
        this.movimentacaoEstoqueRepository = movimentacaoEstoqueRepository;
    }

    @Transactional
    public ResponseEntity<MovimentacaoEstoque> save(MovimentacaoEstoque movimentacaoEstoque) {
        movimentacaoEstoqueRepository.save(movimentacaoEstoque);
        logger.info("Movimentacao salva com sucesso.");
        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<MovimentacaoEstoque> deleteById(Number id) {
        logger.info("Procurando movimentacao com id: " + id);
        if(!movimentacaoEstoqueRepository.existsById((Long) id)){
            logger.warn("Não encontrado.");
            return ResponseEntity.notFound().build();
        }
        movimentacaoEstoqueRepository.deleteById((Long) id);
        logger.info("Deletado com sucesso.");
        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<MovimentacaoEstoque> updateById(Number id, MovimentacaoEstoque mv){
        logger.info("Procurando movimentacao para atualizar. Id: " + id);
        if(!movimentacaoEstoqueRepository.existsById((Long) id)){
            logger.warn("Não encontrado");
            return ResponseEntity.notFound().build();
        }
        mv.setId((Long) id);
        MovimentacaoEstoque mvAtt = movimentacaoEstoqueRepository.save(mv);
        logger.info("Atualizado com sucesso.");
        return ResponseEntity.ok(mvAtt);
    }

    public ResponseEntity<Page<MovimentacaoEstoque>> findAll(Pageable pageable){
        Page<MovimentacaoEstoque> movimentacaoEstoques = movimentacaoEstoqueRepository.findAll(pageable);
        logger.info("Encontrado uma lista de movimentacao. Tamanho: " + movimentacaoEstoques.getTotalElements());
        return ResponseEntity.ok(movimentacaoEstoques);
    }

    public ResponseEntity<MovimentacaoEstoque> findById(Number id){
        logger.info("Procurando movimentacao com id: " + id);
        if(!movimentacaoEstoqueRepository.existsById((Long) id)){
            logger.warn("Não encontrado.");
            return ResponseEntity.notFound().build();
        }
        MovimentacaoEstoque movimentacaoEstoque = movimentacaoEstoqueRepository.findById((Long) id).get();
        logger.info("Encontrado com sucesso.");
        return ResponseEntity.ok(movimentacaoEstoque);
    }

}
