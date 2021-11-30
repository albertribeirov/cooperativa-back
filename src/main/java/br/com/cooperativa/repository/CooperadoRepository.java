package br.com.cooperativa.repository;

import br.com.cooperativa.model.Cooperado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CooperadoRepository extends JpaRepository<Cooperado, Long> {
}
