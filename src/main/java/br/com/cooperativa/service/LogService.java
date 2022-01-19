package br.com.cooperativa.service;

import br.com.cooperativa.model.Log;
import br.com.cooperativa.repository.LogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LogService {

    //Logger to easy debug
    private static final Logger logger = LoggerFactory.getLogger(ClienteService.class);

    private final LogRepository logRepository;

    // Dependency Injection
    public LogService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @Transactional
    public ResponseEntity<Log> save(Log log){
        logRepository.save(log);
        logger.info("Log salvo com sucesso.");
        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<Log> deleteById(Number id){
        logger.info("Procurando log com id: " + id);
        if(!logRepository.existsById((Long) id)){
            logger.warn("Não encontrado.");
            return ResponseEntity.notFound().build();
        }
        logRepository.deleteById((Long) id);
        logger.info("Deletado com sucesso.");
        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<Log> updateById(Number id, Log log){
        logger.info("Procurando Log com id: " + id);
        if(!logRepository.existsById((Long) id)){
            logger.warn("Não encontrado");
            return ResponseEntity.notFound().build();
        }
        log.setId((Long) id);
        Log logAtt = logRepository.save(log);
        logger.info("Atualizado com sucesso.");
        return ResponseEntity.ok(logAtt);
    }

    public ResponseEntity<Page<Log>> findAll(Pageable pageable){
        Page<Log> logs = logRepository.findAll(pageable);
        logger.info("Lista de logs encontrada. Tamanho: " + logs.getTotalElements());
        return ResponseEntity.ok(logs);
    }

    public ResponseEntity<Log> findById(Number id){
        logger.info("Procurando Log com id: " + id);
        if(!logRepository.existsById((Long) id)){
            logger.warn("Não encontrado");
            return ResponseEntity.notFound().build();
        }
        Log log = logRepository.findById((Long) id).get();
        logger.info("Encontrado Log com id: " + id);
        return ResponseEntity.ok(log);
    }

}
