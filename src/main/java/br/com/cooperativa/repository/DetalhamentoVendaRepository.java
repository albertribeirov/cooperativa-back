package br.com.cooperativa.repository;

import br.com.cooperativa.model.DetalhamentoVenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalhamentoVendaRepository extends JpaRepository<DetalhamentoVenda, Long> {
}
