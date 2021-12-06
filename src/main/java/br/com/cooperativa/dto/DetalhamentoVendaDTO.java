package br.com.cooperativa.dto;

import br.com.cooperativa.model.Cliente;
import br.com.cooperativa.model.DetalhamentoVenda;
import br.com.cooperativa.model.Material;
import br.com.cooperativa.model.Venda;

import java.io.Serializable;
import java.util.Objects;

public class DetalhamentoVendaDTO implements Serializable {

    private Venda venda;
    private Cliente cliente;
    private TipoMaterialDTO tipoMaterial;
    private Material material;

    public DetalhamentoVendaDTO() {
    }

    // Transformation DTO -> DetalhamentoVenda
    public DetalhamentoVenda dtoToDetalhamentoVenda(){
        return new DetalhamentoVenda(this.venda, this.cliente, this.tipoMaterial, this.material);
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public TipoMaterialDTO getTipoMaterial() {
        return tipoMaterial;
    }

    public void setTipoMaterial(TipoMaterialDTO tipoMaterial) {
        this.tipoMaterial = tipoMaterial;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DetalhamentoVendaDTO that = (DetalhamentoVendaDTO) o;
        return Objects.equals(venda, that.venda) && Objects.equals(cliente, that.cliente) && Objects.equals(tipoMaterial, that.tipoMaterial) && Objects.equals(material, that.material);
    }

    @Override
    public int hashCode() {
        return Objects.hash(venda, cliente, tipoMaterial, material);
    }
}
