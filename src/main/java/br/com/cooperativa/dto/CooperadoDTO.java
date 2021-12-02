package br.com.cooperativa.dto;

import br.com.cooperativa.model.Cooperado;
import br.com.cooperativa.model.Endereco;

import java.io.Serializable;
import java.util.Objects;

public class CooperadoDTO implements Serializable {

    private String nomeCompleto;
    private String telefoneUm;
    private String telefoneDois;
    private Endereco endereco = new Endereco();
    private String cpf;
    private boolean ativo;
    private String observacao;

    public CooperadoDTO() {
    }

    // Transformation DTO -> Cooperado
    public Cooperado dtoToCooperado(){
        return new Cooperado(this.nomeCompleto, this.telefoneUm, this.telefoneDois, this.endereco, this.cpf, this.ativo, this.observacao);
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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
        CooperadoDTO that = (CooperadoDTO) o;
        return ativo == that.ativo && nomeCompleto.equals(that.nomeCompleto) && Objects.equals(telefoneUm, that.telefoneUm) && Objects.equals(telefoneDois, that.telefoneDois) && Objects.equals(endereco, that.endereco) && cpf.equals(that.cpf) && Objects.equals(observacao, that.observacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeCompleto, telefoneUm, telefoneDois, endereco, cpf, ativo, observacao);
    }
}
