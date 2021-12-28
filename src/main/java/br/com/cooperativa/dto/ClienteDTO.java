package br.com.cooperativa.dto;

import br.com.cooperativa.model.Cliente;
import br.com.cooperativa.model.Endereco;
import br.com.cooperativa.utils.TypeUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteDTO implements Serializable {

    @NotEmpty(message = "Inserir um nome é obrigatório.")
    private String nome;

    @NotEmpty(message = "Inserir um telefone principal é obrigatório.")
    private String telefoneUm;

    private String telefoneDois;

    private Endereco endereco = new Endereco();

    @NotEmpty(message = "Inserir um cpf é obrigatório.")
    @CPF(message = "Insira um cpf válido.")
    private String cpf_cnpj;

    private boolean ativo;

    private String observacao;

    // Transformation DTO -> Original Model
    public Cliente dtoToCliente(){
        return TypeUtils.parseToEntity(this, Cliente.class);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClienteDTO that = (ClienteDTO) o;
        return ativo == that.ativo && Objects.equals(nome, that.nome) && Objects.equals(telefoneUm, that.telefoneUm) && Objects.equals(telefoneDois, that.telefoneDois) && Objects.equals(endereco, that.endereco) && Objects.equals(cpf_cnpj, that.cpf_cnpj) && Objects.equals(observacao, that.observacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, telefoneUm, telefoneDois, endereco, cpf_cnpj, ativo, observacao);
    }
}
