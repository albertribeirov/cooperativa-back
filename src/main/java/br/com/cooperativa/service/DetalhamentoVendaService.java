package br.com.cooperativa.service;

import br.com.cooperativa.model.DetalhamentoVenda;
import br.com.cooperativa.repository.DetalhamentoVendaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DetalhamentoVendaService {

    private final DetalhamentoVendaRepository detalhamentoVendaRepository;

    // Dependency Injection
    public DetalhamentoVendaService(DetalhamentoVendaRepository detalhamentoVendaRepository) {
        this.detalhamentoVendaRepository = detalhamentoVendaRepository;
    }

    @Transactional
    public ResponseEntity<DetalhamentoVenda> save(DetalhamentoVenda detalhamentoVenda){
        detalhamentoVendaRepository.save(detalhamentoVenda);
        return ResponseEntity.ok().build();
    }
}
