package br.com.cooperativa.service;

import br.com.cooperativa.model.Endereco;
import br.com.cooperativa.repository.EnderecoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

}
