package br.com.cooperativa.service;

import br.com.cooperativa.model.Estoque;
import br.com.cooperativa.repository.EstoqueRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EstoqueService {

    //Logger to easy debug
    private static final Logger logger = LoggerFactory.getLogger(ClienteService.class);

    private final EstoqueRepository estoqueRepository;

    // Dependency Injection
    public EstoqueService(EstoqueRepository estoqueRepository) {
        this.estoqueRepository = estoqueRepository;
    }

    @Transactional
    public ResponseEntity<Estoque> save(Estoque estoque) {
        estoqueRepository.save(estoque);
        logger.info("Estoque salvo com sucesso.");
        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<Estoque> deleteById(Number id) {
        logger.info("Procurando estoque para deletar com id: " + id);
        if (!estoqueRepository.existsById((Long) id)) {
            logger.warn("Não encontrado");
            return ResponseEntity.notFound().build();
        }
        estoqueRepository.deleteById((Long) id);
        logger.info("Deletado com sucesso.");
        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<Estoque> updateById(Number id, Estoque estoque) {
        logger.info("Procurando estoque com id: " + id);
        if (!estoqueRepository.existsById((Long) id)) {
            logger.warn("Não encontrado");
            return ResponseEntity.notFound().build();
        }
        estoque.setId((Long) id);
        Estoque estoqueAtt = estoqueRepository.save(estoque);
        logger.info("Estoque salvo com sucesso.");
        return ResponseEntity.ok(estoqueAtt);
    }

    public ResponseEntity<List<Estoque>> findAll() {
        List<Estoque> estoques = estoqueRepository.findAll();
        logger.info("Lista de estoque encontrado. Tamanho: " + estoques.size());
        return ResponseEntity.ok(estoques);
    }

    public ResponseEntity<Estoque> findById(Number id) {
        logger.info("Procurando estoque com id: " + id);
        if (!estoqueRepository.existsById((Long) id)){
            logger.warn("Não encontrado");
            return ResponseEntity.notFound().build();
        }
        Estoque estoque = estoqueRepository.findById((Long) id).get();
        logger.info("Encontrado com sucesso.");
        return ResponseEntity.ok(estoque);
    }

}
