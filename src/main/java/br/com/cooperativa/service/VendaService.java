package br.com.cooperativa.service;

import br.com.cooperativa.model.Venda;
import br.com.cooperativa.repository.VendaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VendaService {

    //Logger to easy debug
    private static final Logger logger = LoggerFactory.getLogger(ClienteService.class);

    private final VendaRepository vendaRepository;

    // Dependency Injection
    public VendaService(VendaRepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }

    @Transactional
    public ResponseEntity<Venda> save(Venda venda){
        vendaRepository.save(venda);
        logger.info("Venda salva com sucesso.");
        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<Venda> deleteById(Number id){
        logger.info("Procurando venda com id: " + id);
        if(!vendaRepository.existsById((Long) id)){
            logger.warn("Não encontrado.");
            return ResponseEntity.notFound().build();
        }
        vendaRepository.deleteById((Long) id);
        logger.info("Deletado com sucesso.");
        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<Venda> updateById(Number id, Venda venda){
        logger.info("Procurando venda com id: " + id);
        if(!vendaRepository.existsById((Long) id)){
            logger.warn("Não encontrado.");
            return ResponseEntity.notFound().build();
        }
        venda.setId((Long) id);
        Venda vendaAtt = vendaRepository.save(venda);
        logger.info("Atualizado com sucesso.");
        return ResponseEntity.ok(vendaAtt);
    }

    public ResponseEntity<List<Venda>> findAll(){
        List<Venda> vendas = vendaRepository.findAll();
        logger.info("Encontrado lista de vendas. Tamanho: " + vendas.size());
        return ResponseEntity.ok(vendas);
    }

    public ResponseEntity<Venda> findById(Number id){
        logger.info("Procurando Vendas com id: " + id);
        if(!vendaRepository.existsById((Long) id)){
            logger.warn("Não encontrado.");
            return ResponseEntity.notFound().build();
        }
        Venda venda = vendaRepository.findById((Long) id).get();
        logger.info("Encontrado com sucesso. Nota Fiscal: " + venda.getNotaFiscal());
        return ResponseEntity.ok(venda);
    }

}
