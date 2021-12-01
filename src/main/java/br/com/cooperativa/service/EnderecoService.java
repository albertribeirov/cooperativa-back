package br.com.cooperativa.service;

import br.com.cooperativa.model.Endereco;
import br.com.cooperativa.repository.EnderecoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;

    // Dependency Injection
    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    @Transactional
    public ResponseEntity<Endereco> save(Endereco endereco){
        enderecoRepository.save(endereco);
        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<Endereco> deleteById(Number id){
        if(!enderecoRepository.existsById((Long) id)){
            return ResponseEntity.notFound().build();
        }
        enderecoRepository.deleteById((Long) id);
        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<Endereco> updateById(Number id, Endereco endereco){
        if(!enderecoRepository.existsById((Long) id)){
            return ResponseEntity.notFound().build();
        }
        endereco.setId((Long) id);
        Endereco enderecoAtt = enderecoRepository.save(endereco);
        return ResponseEntity.ok(enderecoAtt);
    }

    public ResponseEntity<List<Endereco>> findAll(){
        List<Endereco> enderecos = enderecoRepository.findAll();
        return ResponseEntity.ok(enderecos);
    }

    public ResponseEntity<Endereco> findById(Number id){
        if(!enderecoRepository.existsById((Long) id)){
            return ResponseEntity.notFound().build();
        }
        Endereco endereco = enderecoRepository.findById((Long) id).get();
        return ResponseEntity.ok(endereco);
    }

}
