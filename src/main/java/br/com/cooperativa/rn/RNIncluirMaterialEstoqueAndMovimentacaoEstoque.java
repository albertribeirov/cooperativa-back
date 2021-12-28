package br.com.cooperativa.rn;

import br.com.cooperativa.model.Estoque;
import br.com.cooperativa.model.MovimentacaoEstoque;
import br.com.cooperativa.repository.EstoqueRepository;
import br.com.cooperativa.repository.MovimentacaoEstoqueRepository;

public class RNIncluirMaterialEstoqueAndMovimentacaoEstoque {

    private static RNIncluirMaterialEstoqueAndMovimentacaoEstoque regraDeNegocio;

    public static RNIncluirMaterialEstoqueAndMovimentacaoEstoque getInstance() {
        if (regraDeNegocio == null) {
            regraDeNegocio = new RNIncluirMaterialEstoqueAndMovimentacaoEstoque();
        }
        return regraDeNegocio;
    }

    public void incluir(MovimentacaoEstoque movimentacaoEstoque,
                        EstoqueRepository estoqueRepository,
                        MovimentacaoEstoqueRepository movimentacaoEstoqueRepository) {

        Estoque estoque = estoqueRepository.consultarEstoquePorIdMaterial(movimentacaoEstoque.getMaterial().getId());
        estoque.setQuantidadeEmKg(estoque.getQuantidadeEmKg() + movimentacaoEstoque.getQuantidadeEmKg());

        movimentacaoEstoqueRepository.save(movimentacaoEstoque);
        estoqueRepository.save(estoque);
    }
}