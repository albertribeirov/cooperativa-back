package br.com.cooperativa.dto;

import br.com.cooperativa.model.Cliente;
import br.com.cooperativa.model.DetalhamentoVenda;
import br.com.cooperativa.model.Material;
import br.com.cooperativa.model.Venda;
import br.com.cooperativa.utils.TypeUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetalhamentoVendaDTO implements Serializable {

    private Venda venda;
    private Cliente cliente;
    private TipoMaterialDTO tipoMaterial;
    private Material material;

    // Transformation DTO -> DetalhamentoVenda
    public DetalhamentoVenda dtoToDetalhamentoVenda(){
        return TypeUtils.parseToEntity(this, DetalhamentoVenda.class);
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
