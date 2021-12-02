package br.com.cooperativa.dto;

import br.com.cooperativa.enumeration.TipoMovimentacaoEstoque;
import br.com.cooperativa.model.Material;
import br.com.cooperativa.model.MovimentacaoEstoque;
import br.com.cooperativa.model.TipoMaterial;

import java.io.Serializable;
import java.time.LocalDate;

public class MovimentacaoEstoqueDTO implements Serializable {

    private Integer quantidade;
    private TipoMovimentacaoEstoque tipoMovimentacaoEstoque;
    private TipoMaterial tipoMaterial ;
    private Material material;
    private LocalDate dataMovimentacao;

    public MovimentacaoEstoqueDTO() {
    }

    // Transformation DTO -> MovimentacaoEstoque
    public MovimentacaoEstoque dtoToMovimentacaoEstoque(){
        return new MovimentacaoEstoque(this.quantidade, this.tipoMovimentacaoEstoque, this.tipoMaterial, this.material, this.dataMovimentacao);
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public TipoMovimentacaoEstoque getTipoMovimentacaoEstoque() {
        return tipoMovimentacaoEstoque;
    }

    public void setTipoMovimentacaoEstoque(TipoMovimentacaoEstoque tipoMovimentacaoEstoque) {
        this.tipoMovimentacaoEstoque = tipoMovimentacaoEstoque;
    }

    public TipoMaterial getTipoMaterial() {
        return tipoMaterial;
    }

    public void setTipoMaterial(TipoMaterial tipoMaterial) {
        this.tipoMaterial = tipoMaterial;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }
}
