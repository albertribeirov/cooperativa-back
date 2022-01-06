package br.com.cooperativa.service;

import br.com.cooperativa.model.Cliente;
import br.com.cooperativa.repository.ClienteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ClienteService {

    // Logger to debug
    private static final Logger logger = LoggerFactory.getLogger(ClienteService.class);

    private final ClienteRepository clienteRepository;

    // Dependency Injection
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Transactional
    public ResponseEntity<Cliente> save(Cliente cliente) {
        logger.info("Salvando cliente no banco de dados.");
        clienteRepository.save(cliente);
        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<Cliente> deleteByID(Number id) {
        // cast to Long because I don't know the type of Id
        Optional<Cliente> clienteOptional = clienteRepository.findById((Long) id);
        logger.info("Procurando um cliente com id " + id);
        if (clienteOptional.isPresent()) {
            logger.info("Cliente removido.");
            clienteRepository.delete(clienteOptional.get());
            return ResponseEntity.ok().build();
        }
        logger.warn("Cliente não encontrado não encontrado com id " + id);
        return ResponseEntity.notFound().build();
    }

    @Transactional
    public ResponseEntity<Cliente> updateByID(Number id, Cliente cliente) {
        logger.info("Procurando cliente para atualizar");
        if (!clienteRepository.existsById((Long) id)) {
            logger.warn("Cliente com id " + id + "não encontrado");
            return ResponseEntity.notFound().build();
        }
        cliente.setId((Long) id);
        Cliente clienteAtt = clienteRepository.save(cliente);
        logger.info("Cliente atualizado");
        return ResponseEntity.ok(clienteAtt);

    }

    public ResponseEntity<Page<Cliente>> findAll(Pageable pageable) {
        logger.info("Procurando todos os clientes.");
        Page<Cliente> clientes = clienteRepository.findAll(pageable);
        return ResponseEntity.ok(clientes);
    }

    public ResponseEntity<Cliente> findById(Number id) {
        logger.info("Procurando cliente com id " + id);
        Optional<Cliente> clienteOptional = clienteRepository.findById((Long) id);
        if (clienteOptional.isPresent()) {
            logger.info("Cliente encontrado");
            return ResponseEntity.ok(clienteOptional.get());
        }
        logger.warn("Cliente não encontrado.");
        return ResponseEntity.notFound().build();

    }

}
