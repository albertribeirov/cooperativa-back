package br.com.cooperativa.service;

import br.com.cooperativa.model.Cooperado;
import br.com.cooperativa.repository.CooperadoRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CooperadoService {

    private final CooperadoRepository cooperadoRepository;

    // Dependency Injection
    public CooperadoService(CooperadoRepository cooperadoRepository) {
        this.cooperadoRepository = cooperadoRepository;
    }

    @Transactional
    public ResponseEntity<Cooperado> save(Cooperado cooperado){
        cooperadoRepository.save(cooperado);
        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<Cooperado> deleteById(Number id){
        if(!cooperadoRepository.existsById((Long) id)){
            return ResponseEntity.notFound().build();
        }
        cooperadoRepository.deleteById((Long) id);
        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<Cooperado> updateById(Number id, Cooperado cooperado){
        if(!cooperadoRepository.existsById((Long) id)){
            return ResponseEntity.notFound().build();
        }
        cooperado.setId((Long) id);
        Cooperado cooperado_att = cooperadoRepository.save(cooperado);
        return ResponseEntity.ok(cooperado_att);
    }

    public ResponseEntity<Cooperado> findById(Number id){
        if(!cooperadoRepository.existsById((Long) id)){
            return ResponseEntity.notFound().build();
        }
        Cooperado cooperado = cooperadoRepository.findById((Long) id).get();
        return ResponseEntity.ok(cooperado);
    }

    public ResponseEntity<List<Cooperado>> findAll(){
        List<Cooperado> cooperados = cooperadoRepository.findAll();
        return ResponseEntity.ok(cooperados);
    }

}
