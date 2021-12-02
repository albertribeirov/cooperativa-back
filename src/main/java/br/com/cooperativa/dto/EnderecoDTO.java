package br.com.cooperativa.dto;

import br.com.cooperativa.model.Endereco;

import java.io.Serializable;

public class EnderecoDTO implements Serializable {

    private String ruaComNumero;
    private String bairro;
    private String cidade;
    private String cep;

    public EnderecoDTO() {
    }

    public Endereco dtoToEndereco(){
        return new Endereco(this.ruaComNumero, this.bairro, this.cidade, this.cep);
    }

    public String getRuaComNumero() {
        return ruaComNumero;
    }

    public void setRuaComNumero(String ruaComNumero) {
        this.ruaComNumero = ruaComNumero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
