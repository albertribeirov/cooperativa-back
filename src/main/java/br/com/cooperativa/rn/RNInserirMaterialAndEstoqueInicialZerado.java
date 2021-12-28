package br.com.cooperativa.rn;

import br.com.cooperativa.enumeration.TipoMovimentacaoEstoque;
import br.com.cooperativa.model.Estoque;
import br.com.cooperativa.model.Material;
import br.com.cooperativa.model.MovimentacaoEstoque;
import br.com.cooperativa.repository.EstoqueRepository;
import br.com.cooperativa.repository.MaterialRepository;
import br.com.cooperativa.repository.MovimentacaoEstoqueRepository;

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
                .quantidadeEmKg(0D)
                .tipoMaterial(material.getTipoMaterial())
                .material(material)
                .build();

        MovimentacaoEstoque movimentacaoEstoque = MovimentacaoEstoque.builder()
                .quantidade(0D)
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