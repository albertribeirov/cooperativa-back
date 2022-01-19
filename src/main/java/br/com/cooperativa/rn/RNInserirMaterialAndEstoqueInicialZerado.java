package br.com.cooperativa.rn;

import br.com.cooperativa.enumeration.TipoMovimentacaoEstoque;
import br.com.cooperativa.model.Estoque;
import br.com.cooperativa.model.Material;
import br.com.cooperativa.model.MovimentacaoEstoque;
import br.com.cooperativa.repository.EstoqueRepository;
import br.com.cooperativa.repository.MaterialRepository;
import br.com.cooperativa.repository.MovimentacaoEstoqueRepository;

import java.math.BigDecimal;
import java.time.LocalDate;

public class RNInserirMaterialAndEstoqueInicialZerado {

    private static RNInserirMaterialAndEstoqueInicialZerado regraDeNegocio;

    public static RNInserirMaterialAndEstoqueInicialZerado getInstance() {
        if (regraDeNegocio == null) {
            regraDeNegocio = new RNInserirMaterialAndEstoqueInicialZerado();
        }
        return regraDeNegocio;
    }

    public void inserir(Material material,
                        EstoqueRepository estoqueRepository,
                        MaterialRepository materialRepository,
                        MovimentacaoEstoqueRepository movimentacaoEstoqueRepository) {

        Estoque estoque = Estoque.builder()
                .quantidadeEmKg(BigDecimal.ZERO)
                .tipoMaterial(material.getTipoMaterial())
                .material(material)
                .build();

        MovimentacaoEstoque movimentacaoEstoque = MovimentacaoEstoque.builder()
                .quantidadeEmKg(BigDecimal.ZERO)
                .tipoMovimentacaoEstoque(TipoMovimentacaoEstoque.ENTRADA)
                .tipoMaterial(material.getTipoMaterial())
                .material(material)
                .dataMovimentacao(LocalDate.now())
                .build();


        materialRepository.save(material);
        movimentacaoEstoqueRepository.save(movimentacaoEstoque);
        estoqueRepository.save(estoque);
    }
}