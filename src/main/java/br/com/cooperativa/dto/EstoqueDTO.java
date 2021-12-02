package br.com.cooperativa.dto;

import br.com.cooperativa.model.Estoque;
import br.com.cooperativa.model.Material;
import br.com.cooperativa.model.TipoMaterial;

import java.io.Serializable;

public class EstoqueDTO implements Serializable {

    private Integer quantidadeEmKg;
    private TipoMaterial tipoMaterial;
    private Material material;

    public EstoqueDTO() {
    }

    // Transformation DTO -> Estoque
    public Estoque dtoToEstoque(){
        return new Estoque(this.quantidadeEmKg, this.tipoMaterial, this.material);
    }

    public Integer getQuantidadeEmKg() {
        return quantidadeEmKg;
    }

    public void setQuantidadeEmKg(Integer quantidadeEmKg) {
        this.quantidadeEmKg = quantidadeEmKg;
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
