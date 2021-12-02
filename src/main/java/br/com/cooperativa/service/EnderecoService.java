package br.com.cooperativa.service;

import br.com.cooperativa.model.Endereco;
import br.com.cooperativa.repository.EnderecoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EnderecoService {

    //Logger to easy debug
    private static final Logger logger = LoggerFactory.getLogger(ClienteService.class);

    private final EnderecoRepository enderecoRepository;

    // Dependency Injection
    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    @Transactional
    public ResponseEntity<Endereco> save(Endereco endereco){
        enderecoRepository.save(endereco);
        logger.info("Endereco salvo.");
        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<Endereco> deleteById(Number id){
        logger.info("Deletando endereco com id " + id);
        if(!enderecoRepository.existsById((Long) id)){
            logger.warn("Não encontrado.");
            return ResponseEntity.notFound().build();
        }
        enderecoRepository.deleteById((Long) id);
        logger.info("Deletado com sucesso");
        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<Endereco> updateById(Number id, Endereco endereco){
        logger.info("Atualizando endereco com id " + id);
        if(!enderecoRepository.existsById((Long) id)){
            logger.warn("Não encontrado");
            return ResponseEntity.notFound().build();
        }
        endereco.setId((Long) id);
        Endereco enderecoAtt = enderecoRepository.save(endereco);
        logger.info("Atualizado com sucesso.");
        return ResponseEntity.ok(enderecoAtt);
    }

    public ResponseEntity<List<Endereco>> findAll(){
        List<Endereco> enderecos = enderecoRepository.findAll();
        logger.info("Encontrado lista de endereco. Tamanho: " + enderecos.size());
        return ResponseEntity.ok(enderecos);
    }

    public ResponseEntity<Endereco> findById(Number id){
        logger.info("Procurando endereco com id " + id);
        if(!enderecoRepository.existsById((Long) id)){
            logger.warn("Não encontrado");
            return ResponseEntity.notFound().build();
        }
        Endereco endereco = enderecoRepository.findById((Long) id).get();
        logger.info("Encontrado endereco com id " + id);
        return ResponseEntity.ok(endereco);
    }

}
