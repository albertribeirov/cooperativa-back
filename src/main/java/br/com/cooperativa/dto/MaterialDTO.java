package br.com.cooperativa.dto;

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
public class MaterialDTO implements Serializable {

    private String nome;
    private TipoMaterial tipoMaterial ;

    public Material dtoToMaterial(){
        return TypeUtils.parseToEntity(this, Material.class);
    }

}
