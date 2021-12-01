package br.com.cooperativa.service;

import br.com.cooperativa.model.Cliente;
import br.com.cooperativa.repository.ClienteRepository;
import org.springframework.data.repository.config.RepositoryNameSpaceHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    // Dependency Injection
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Transactional
    public ResponseEntity<Cliente> save(Cliente cliente){
        clienteRepository.save(cliente);
        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<Cliente> deleteByID(Number id){
        // cast to Long because I don't know the type of Id
        Optional<Cliente> clienteOptional = clienteRepository.findById((Long) id);
        if(clienteOptional.isPresent()){
            clienteRepository.delete(clienteOptional.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Transactional
    public ResponseEntity<List<Cliente>> updateByID(Number id, Cliente cliente){
        Optional<Cliente> clienteOptional = clienteRepository.findById((Long) id);
        if(clienteOptional.isPresent()){
            Cliente clienteExists = clienteOptional.get();
            clienteExists.setAtivo(cliente.isAtivo());
            clienteExists.setCpf_cnpj(cliente.getCpf_cnpj());
            clienteExists.setUpdateDateTime(cliente.getUpdateDateTime());
            clienteExists.setEndereco(cliente.getEndereco());
            clienteExists.setNome(cliente.getNome());
            clienteExists.setObservacao(cliente.getObservacao());
            clienteExists.setTelefoneUm(cliente.getTelefoneUm());
            clienteExists.setTelefoneDois(cliente.getTelefoneDois());

            clienteRepository.save(clienteExists);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<List<Cliente>> findAll(){
        List<Cliente> clientes = clienteRepository.findAll();
        return ResponseEntity.ok(clientes);
    }

    public ResponseEntity<Cliente> findById(Number id){
        Optional<Cliente> clienteOptional = clienteRepository.findById((Long) id);
        if(clienteOptional.isPresent()){
            return ResponseEntity.ok(clienteOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
