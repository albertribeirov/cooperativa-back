package br.com.cooperativa.service;

import br.com.cooperativa.model.Log;
import br.com.cooperativa.repository.LogRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LogService {

    private final LogRepository logRepository;

    // Dependency Injection
    public LogService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @Transactional
    public ResponseEntity<Log> save(Log log){
        logRepository.save(log);
        return ResponseEntity.ok().build();
    }

}
