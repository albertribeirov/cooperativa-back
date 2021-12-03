package br.com.cooperativa.dto;

import br.com.cooperativa.model.Cliente;
import br.com.cooperativa.model.Endereco;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Objects;

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

    public ClienteDTO() {
    }

    // Transformation DTO -> Original Model
    public Cliente dtoToCliente(){
        return new Cliente(this.nome, this.telefoneUm, this.telefoneDois, this.endereco, this.cpf_cnpj, this.ativo, this.observacao);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefoneUm() {
        return telefoneUm;
    }

    public void setTelefoneUm(String telefoneUm) {
        this.telefoneUm = telefoneUm;
    }

    public String getTelefoneDois() {
        return telefoneDois;
    }

    public void setTelefoneDois(String telefoneDois) {
        this.telefoneDois = telefoneDois;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getCpf_cnpj() {
        return cpf_cnpj;
    }

    public void setCpf_cnpj(String cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
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
