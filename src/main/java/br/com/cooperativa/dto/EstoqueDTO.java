package br.com.cooperativa.dto;

import br.com.cooperativa.model.Estoque;
import br.com.cooperativa.model.Material;
import br.com.cooperativa.model.TipoMaterial;
import br.com.cooperativa.utils.TypeUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EstoqueDTO implements Serializable {

    private Double quantidadeEmKg;
    private TipoMaterial tipoMaterial;
    private Material material;

    // Transformation DTO -> Estoque
    public Estoque dtoToEstoque(){
        return TypeUtils.parseToEntity(this, Estoque.class);
    }

}
