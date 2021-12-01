package br.com.cooperativa.service;

import br.com.cooperativa.model.Venda;
import br.com.cooperativa.repository.VendaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class VendaService {

    private final VendaRepository vendaRepository;

    // Dependency Injection
    public VendaService(VendaRepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }

    public ResponseEntity<Venda> save(Venda venda){
        vendaRepository.save(venda);
        return ResponseEntity.ok().build();
    }
}
