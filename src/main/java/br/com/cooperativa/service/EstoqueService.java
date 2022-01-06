package br.com.cooperativa.service;

import br.com.cooperativa.model.Estoque;
import br.com.cooperativa.repository.EstoqueRepository;
import br.com.cooperativa.repository.MovimentacaoEstoqueRepository;
import br.com.cooperativa.rn.RNInserirQuantidadeMaterialEmEstoque;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EstoqueService {

    //Logger to easy debug
    private static final Logger logger = LoggerFactory.getLogger(ClienteService.class);

    private final EstoqueRepository estoqueRepository;
    private final MovimentacaoEstoqueRepository movimentacaoEstoqueRepository;

    // Dependency Injection
    public EstoqueService(EstoqueRepository estoqueRepository, MovimentacaoEstoqueRepository movimentacaoEstoqueRepository) {
        this.estoqueRepository = estoqueRepository;
        this.movimentacaoEstoqueRepository = movimentacaoEstoqueRepository;
    }

    @Transactional
    public ResponseEntity<Estoque> save(Estoque estoque) {
        try {
            RNInserirQuantidadeMaterialEmEstoque.getInstance().inserir(estoque, estoqueRepository, movimentacaoEstoqueRepository);
            logger.info("Estoque salvo com sucesso.");
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            // TODO Verificar com o front o tratamento da mensagem de erro
            return ResponseEntity.internalServerError().build();
        }
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

    public ResponseEntity<Page<Estoque>> findAll(Pageable pageable) {
        Page<Estoque> estoques = estoqueRepository.findAll(pageable);
        logger.info("Lista de estoque encontrado. Tamanho: " + estoques.getTotalElements());
        return ResponseEntity.ok(estoques);
    }

    public ResponseEntity<Estoque> findById(Number id) {
        logger.info("Procurando estoque com id: " + id);
        if (!estoqueRepository.existsById((Long) id)) {
            logger.warn("Não encontrado");
            return ResponseEntity.notFound().build();
        }
        Estoque estoque = estoqueRepository.findById((Long) id).get();
        logger.info("Encontrado com sucesso.");
        return ResponseEntity.ok(estoque);
    }

    public ResponseEntity<List<Estoque>> listarEstoqueOrderByTipoMaterialAndMaterial() {
        List<Estoque> itensEmEstoque = estoqueRepository.listarEstoqueOrderByTipoMaterialAndMaterial();
        if (itensEmEstoque.isEmpty()) {
            return ResponseEntity.ok(Collections.emptyList());
        }

        return ResponseEntity.ok(itensEmEstoque);
    }

}
