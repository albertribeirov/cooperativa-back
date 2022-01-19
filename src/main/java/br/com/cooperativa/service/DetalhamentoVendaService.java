package br.com.cooperativa.service;

import br.com.cooperativa.model.DetalhamentoVenda;
import br.com.cooperativa.repository.DetalhamentoVendaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DetalhamentoVendaService {

    //Logger to easy debug
    private static final Logger logger = LoggerFactory.getLogger(ClienteService.class);

    private final DetalhamentoVendaRepository detalhamentoVendaRepository;

    // Dependency Injection
    public DetalhamentoVendaService(DetalhamentoVendaRepository detalhamentoVendaRepository) {
        this.detalhamentoVendaRepository = detalhamentoVendaRepository;
    }

    @Transactional
    public ResponseEntity<DetalhamentoVenda> save(DetalhamentoVenda detalhamentoVenda) {
        detalhamentoVendaRepository.save(detalhamentoVenda);
        logger.info("Salvo com sucesso.");
        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<DetalhamentoVenda> deleteById(Number id) {
        logger.info("Deletando detalhamento com id " + id);
        if (!detalhamentoVendaRepository.existsById((Long) id)) {
            logger.warn("Não encontrado.");
            return ResponseEntity.notFound().build();
        }
        detalhamentoVendaRepository.deleteById((Long) id);
        logger.info("Deletado com sucesso.");
        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<DetalhamentoVenda> updateById(Number id, DetalhamentoVenda detalhamentoVenda){
        logger.info("Atualizando detalhamento com id " + id);
        if(!detalhamentoVendaRepository.existsById((Long) id)){
            logger.warn("Não encontrado.");
            return ResponseEntity.notFound().build();
        }
        detalhamentoVenda.setId((Long) id);
        DetalhamentoVenda detalhamentoVendaAtt = detalhamentoVendaRepository.save(detalhamentoVenda);
        logger.info("Atualizado com sucesso.");
        return ResponseEntity.ok(detalhamentoVendaAtt);
    }

    public ResponseEntity<Page<DetalhamentoVenda>> findAll(Pageable pageable){
        Page<DetalhamentoVenda> detalhamentoVendas = detalhamentoVendaRepository.findAll(pageable);
        logger.info("Encontrado lista de detalhamentos. Tamanho: " + detalhamentoVendas.getTotalElements());
        return ResponseEntity.ok(detalhamentoVendas);
    }

    public ResponseEntity<DetalhamentoVenda> findById(Number id){
        logger.info("Encontrando detalhamento com id " + id);
        if(!detalhamentoVendaRepository.existsById((Long) id)){
            logger.warn("Não encontrado");
            return ResponseEntity.notFound().build();
        }
        DetalhamentoVenda detalhamentoVenda = detalhamentoVendaRepository.findById((Long) id).get();
        logger.info("Detalhamento com id " + id + " encontrado.");
        return ResponseEntity.ok(detalhamentoVenda);
    }

}
