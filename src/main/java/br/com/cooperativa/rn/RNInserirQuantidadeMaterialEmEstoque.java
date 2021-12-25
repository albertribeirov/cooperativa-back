package br.com.cooperativa.rn;

import br.com.cooperativa.enumeration.TipoMovimentacaoEstoque;
import br.com.cooperativa.model.Estoque;
import br.com.cooperativa.model.MovimentacaoEstoque;
import br.com.cooperativa.repository.EstoqueRepository;
import br.com.cooperativa.repository.MovimentacaoEstoqueRepository;

import java.util.List;

public class RNInserirQuantidadeMaterialEmEstoque {

    private static RNInserirQuantidadeMaterialEmEstoque regraDeNegocio;

    public static RNInserirQuantidadeMaterialEmEstoque getInstance() {
        if (regraDeNegocio == null) {
            regraDeNegocio = new RNInserirQuantidadeMaterialEmEstoque();
        }
        return regraDeNegocio;
    }

    public void inserir(Estoque estoque,
                        EstoqueRepository estoqueRepository,
                        MovimentacaoEstoqueRepository movimentacaoEstoqueRepository) throws Exception {

        Estoque estoqueFromDb;

        List<Estoque> estoques = estoqueRepository.consultaEstoquePorIdMaterialAndIdTipoMaterial(
                estoque.getMaterial().getId(),
                estoque.getTipoMaterial().getId()
        );

        if (estoques.isEmpty()) {
            estoqueRepository.save(estoque);
        } else {
            estoqueFromDb = estoques.get(0);
            estoqueFromDb.setQuantidadeEmKg(estoqueFromDb.getQuantidadeEmKg() + estoque.getQuantidadeEmKg());
            estoqueRepository.save(estoqueFromDb);
        }

        MovimentacaoEstoque movimentacaoEstoque = new MovimentacaoEstoque(
                estoque.getQuantidadeEmKg(),
                TipoMovimentacaoEstoque.ENTRADA,
                estoque.getTipoMaterial(),
                estoque.getMaterial()
        );

        movimentacaoEstoqueRepository.save(movimentacaoEstoque);
    }
}