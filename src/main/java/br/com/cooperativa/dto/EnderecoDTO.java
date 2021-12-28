package br.com.cooperativa.dto;

import br.com.cooperativa.model.Endereco;
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
public class EnderecoDTO implements Serializable {

    private String ruaComNumero;
    private String bairro;
    private String cidade;
    private String cep;

    public Endereco dtoToEndereco() {
        return TypeUtils.parseToEntity(this, Endereco.class);
    }
}
