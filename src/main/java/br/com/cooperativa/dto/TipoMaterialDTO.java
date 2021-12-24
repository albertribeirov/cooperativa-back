package br.com.cooperativa.dto;

import br.com.cooperativa.model.Material;
import br.com.cooperativa.model.TipoMaterial;
import br.com.cooperativa.utils.TypeUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TipoMaterialDTO implements Serializable {

    private String nome;
    private List<Material> materiais;

    public TipoMaterial dtoToTipoMaterial(){
        return TypeUtils.parseToEntity(this, TipoMaterial.class);
    }

}
