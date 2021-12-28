package br.com.cooperativa.dto;

import br.com.cooperativa.enumeration.TipoMovimentacaoEstoque;
import br.com.cooperativa.model.Material;
import br.com.cooperativa.model.MovimentacaoEstoque;
import br.com.cooperativa.model.TipoMaterial;
import br.com.cooperativa.utils.TypeUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovimentacaoEstoqueDTO implements Serializable {

    private Integer quantidade;
    private TipoMovimentacaoEstoque tipoMovimentacaoEstoque;
    private TipoMaterial tipoMaterial ;
    private Material material;
    private LocalDate dataMovimentacao;

    // Transformation DTO -> MovimentacaoEstoque
    public MovimentacaoEstoque dtoToMovimentacaoEstoque(){
        return TypeUtils.parseToEntity(this, MovimentacaoEstoque.class);
    }
}
