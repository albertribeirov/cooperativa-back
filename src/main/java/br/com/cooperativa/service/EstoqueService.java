package br.com.cooperativa.service;

import br.com.cooperativa.model.Estoque;
import br.com.cooperativa.repository.EstoqueRepository;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EstoqueService {

    private final EstoqueRepository estoqueRepository;

    // Dependency Injection
    public EstoqueService(EstoqueRepository estoqueRepository) {
        this.estoqueRepository = estoqueRepository;
    }

    @Transactional
    public ResponseEntity<Estoque> save(Estoque estoque){
        estoqueRepository.save(estoque);
        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<Estoque> deleteById(Number id){
        if(!estoqueRepository.existsById((Long) id)){
            return ResponseEntity.notFound().build();
        }
        estoqueRepository.deleteById((Long) id);
        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<Estoque> updateById(Number id, Estoque estoque){
        if(!estoqueRepository.existsById((Long) id)){
            return ResponseEntity.notFound().build();
        }
        estoque.setId((Long) id);
        Estoque estoqueAtt = estoqueRepository.save(estoque);
        return ResponseEntity.ok(estoqueAtt);
    }

}
