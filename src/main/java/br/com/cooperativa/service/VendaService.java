package br.com.cooperativa.service;

import br.com.cooperativa.model.Venda;
import br.com.cooperativa.repository.VendaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VendaService {

    private final VendaRepository vendaRepository;

    // Dependency Injection
    public VendaService(VendaRepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }

    @Transactional
    public ResponseEntity<Venda> save(Venda venda){
        vendaRepository.save(venda);
        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<Venda> deleteById(Number id){
        if(!vendaRepository.existsById((Long) id)){
            return ResponseEntity.notFound().build();
        }
        vendaRepository.deleteById((Long) id);
        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<Venda> updateById(Number id, Venda venda){
        if(!vendaRepository.existsById((Long) id)){
            return ResponseEntity.notFound().build();
        }
        venda.setId((Long) id);
        Venda vendaAtt = vendaRepository.save(venda);
        return ResponseEntity.ok(vendaAtt);
    }

}
