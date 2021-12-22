package br.com.cooperativa.repository;

import br.com.cooperativa.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query("from Cliente c WHERE c.cpf_cnpj = :cpf")
    Optional<Cliente> findByCpf(String cpf);
}
