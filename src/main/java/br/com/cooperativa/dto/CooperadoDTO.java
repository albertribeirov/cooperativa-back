package br.com.cooperativa.dto;

import br.com.cooperativa.model.Cooperado;
import br.com.cooperativa.model.Endereco;
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
public class CooperadoDTO implements Serializable {

    private String nomeCompleto;
    private String telefoneUm;
    private String telefoneDois;
    private Endereco endereco = new Endereco();
    private String cpf;
    private boolean ativo;
    private String observacao;

    // Transformation DTO -> Cooperado
    public Cooperado dtoToCooperado(){
        return TypeUtils.parseToEntity(this, Cooperado.class);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CooperadoDTO that = (CooperadoDTO) o;
        return ativo == that.ativo && nomeCompleto.equals(that.nomeCompleto) && Objects.equals(telefoneUm, that.telefoneUm) && Objects.equals(telefoneDois, that.telefoneDois) && Objects.equals(endereco, that.endereco) && cpf.equals(that.cpf) && Objects.equals(observacao, that.observacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeCompleto, telefoneUm, telefoneDois, endereco, cpf, ativo, observacao);
    }
}
