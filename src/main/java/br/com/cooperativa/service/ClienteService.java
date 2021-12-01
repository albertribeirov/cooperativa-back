package br.com.cooperativa.service;

import br.com.cooperativa.model.Cliente;
import br.com.cooperativa.repository.ClienteRepository;
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
        }
        return ResponseEntity.notFound().build();

    }

    @Transactional
    public ResponseEntity<Cliente> updateByID(Number id, Cliente cliente){

        if(!clienteRepository.existsById((Long) id)){
            return ResponseEntity.notFound().build();
        }
        cliente.setId((Long) id);
        Cliente cliente_att = clienteRepository.save(cliente);
        return ResponseEntity.ok(cliente_att);

    }

    public ResponseEntity<List<Cliente>> findAll(){
        List<Cliente> clientes = clienteRepository.findAll();
        return ResponseEntity.ok(clientes);
    }

    public ResponseEntity<Cliente> findById(Number id){
        Optional<Cliente> clienteOptional = clienteRepository.findById((Long) id);
        if(clienteOptional.isPresent()){
            return ResponseEntity.ok(clienteOptional.get());
        }
        return ResponseEntity.notFound().build();

    }

}
