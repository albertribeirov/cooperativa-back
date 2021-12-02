package br.com.cooperativa.dto;

import br.com.cooperativa.model.Material;
import br.com.cooperativa.model.TipoMaterial;

import java.io.Serializable;

public class MaterialDTO implements Serializable {

    private String nome;
    private TipoMaterial tipoMaterial ;

    public MaterialDTO() {
    }

    public Material dtoToMaterial(){
        return new Material(this.nome, this.tipoMaterial);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoMaterial getTipoMaterial() {
        return tipoMaterial;
    }

    public void setTipoMaterial(TipoMaterial tipoMaterial) {
        this.tipoMaterial = tipoMaterial;
    }
}
