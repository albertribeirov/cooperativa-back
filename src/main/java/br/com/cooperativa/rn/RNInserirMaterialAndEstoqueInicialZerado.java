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

        Estoque estoque = new Estoque(0, material.getTipoMaterial(), material);
        MovimentacaoEstoque movimentacaoEstoque = new MovimentacaoEstoque(0, TipoMovimentacaoEstoque.ENTRADA, material.getTipoMaterial(), material);

        materialRepository.save(material);
        movimentacaoEstoqueRepository.save(movimentacaoEstoque);
        estoqueRepository.save(estoque);
    }
}