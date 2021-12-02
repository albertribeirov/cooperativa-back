package br.com.cooperativa.dto;

import br.com.cooperativa.model.Material;
import br.com.cooperativa.model.TipoMaterial;

import java.io.Serializable;
import java.util.List;

public class TipoMaterialDTO implements Serializable {

    private String nome;
    private List<Material> materiais;

    public TipoMaterialDTO() {
    }

    public TipoMaterial dtoToTipoMaterial(){
        return new TipoMaterial(this.nome, this.materiais);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Material> getMateriais() {
        return materiais;
    }

    public void setMateriais(List<Material> materiais) {
        this.materiais = materiais;
    }
}
