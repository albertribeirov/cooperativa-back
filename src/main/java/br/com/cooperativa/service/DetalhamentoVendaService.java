package br.com.cooperativa.service;

import br.com.cooperativa.model.DetalhamentoVenda;
import br.com.cooperativa.repository.DetalhamentoVendaRepository;
import org.apache.coyote.Response;
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
    public ResponseEntity<DetalhamentoVenda> save(DetalhamentoVenda detalhamentoVenda) {
        detalhamentoVendaRepository.save(detalhamentoVenda);
        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<DetalhamentoVenda> deleteById(Number id) {
        if (!detalhamentoVendaRepository.existsById((Long) id)) {
            return ResponseEntity.notFound().build();
        }
        detalhamentoVendaRepository.deleteById((Long) id);
        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<DetalhamentoVenda> updateById(Number id, DetalhamentoVenda detalhamentoVenda){
        if(!detalhamentoVendaRepository.existsById((Long) id)){
            return ResponseEntity.notFound().build();
        }
        detalhamentoVenda.setId((Long) id);
        DetalhamentoVenda detalhamentoVendaAtt = detalhamentoVendaRepository.save(detalhamentoVenda);
        return ResponseEntity.ok(detalhamentoVendaAtt);
    }

}
