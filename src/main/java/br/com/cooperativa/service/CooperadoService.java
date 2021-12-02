package br.com.cooperativa.service;

import br.com.cooperativa.model.Cooperado;
import br.com.cooperativa.repository.CooperadoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CooperadoService {

    //Logger to easy debug
    private static final Logger logger = LoggerFactory.getLogger(ClienteService.class);

    private final CooperadoRepository cooperadoRepository;

    // Dependency Injection
    public CooperadoService(CooperadoRepository cooperadoRepository) {
        this.cooperadoRepository = cooperadoRepository;
    }

    @Transactional
    public ResponseEntity<Cooperado> save(Cooperado cooperado){
        logger.info("Salvando cooperado " + cooperado.getNomeCompleto());
        cooperadoRepository.save(cooperado);
        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<Cooperado> deleteById(Number id){
        logger.info("Deletando cooperado com id " + id);
        if(!cooperadoRepository.existsById((Long) id)){
            logger.warn("Cooperado não encontrado");
            return ResponseEntity.notFound().build();
        }
        cooperadoRepository.deleteById((Long) id);
        logger.info("Deletado com sucesso");
        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<Cooperado> updateById(Number id, Cooperado cooperado){
        logger.info("Atualizando cooperado com id " + id);
        if(!cooperadoRepository.existsById((Long) id)){
            logger.warn("Não encontrado");
            return ResponseEntity.notFound().build();
        }
        cooperado.setId((Long) id);
        Cooperado cooperadoAtt = cooperadoRepository.save(cooperado);
        logger.info("Atualizado com sucesso.");
        return ResponseEntity.ok(cooperadoAtt);
    }

    public ResponseEntity<List<Cooperado>> findAll(){
        List<Cooperado> cooperados = cooperadoRepository.findAll();
        logger.info("Encontrado a lista de cooperados. Tamanho: " + cooperados.size());
        return ResponseEntity.ok(cooperados);
    }

    public ResponseEntity<Cooperado> findById(Number id){
        logger.info("Procurando cooperado com id " + id);
        if(!cooperadoRepository.existsById((Long) id)){
            logger.warn("Não encontrado");
            return ResponseEntity.notFound().build();
        }
        Cooperado cooperado = cooperadoRepository.findById((Long) id).get();
        logger.info("Encontrado com sucesso.");
        return ResponseEntity.ok(cooperado);
    }


}
