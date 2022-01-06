package br.com.cooperativa.repository;

import br.com.cooperativa.model.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Long> {

    @Query("FROM Estoque e WHERE e.material.id = :idMaterial AND e.tipoMaterial.id = :idTipoMaterial")
    List<Estoque> consultarEstoquePorIdMaterialAndIdTipoMaterial(Long idMaterial, Long idTipoMaterial);

    @Query("FROM Estoque e WHERE e.material.id = :id")
    Estoque consultarEstoquePorIdMaterial(Long id);

    @Query("FROM Estoque e ORDER BY e.tipoMaterial.nome, e.material.nome")
    List<Estoque> listarEstoqueOrderByTipoMaterialAndMaterial();

}
