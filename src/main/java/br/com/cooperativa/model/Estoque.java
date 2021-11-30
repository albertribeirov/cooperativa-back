package br.com.cooperativa.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Estoque implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "quantidade")
    private Integer quantidadeEmKg;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_tipo_material")
    private TipoMaterial tipoMaterial;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_material")
    private Material material;

    @Column(name = "create_time", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createDateTime;

    @Column(name = "update_time", nullable = false)
    @UpdateTimestamp
    private LocalDateTime updateDateTime;

    public Estoque() {

    }

    public Estoque(Integer quantidadeEmKg, Material material) {
        this.quantidadeEmKg = quantidadeEmKg;
        this.material = material;
    }

    public Estoque(Integer quantidadeEmKg, TipoMaterial tipoMaterial, Material material) {
        this.quantidadeEmKg = quantidadeEmKg;
        this.tipoMaterial = tipoMaterial;
        this.material = material;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantidadeEmKg() {
        return quantidadeEmKg;
    }

    public void setQuantidadeEmKg(Integer quantidadeEmKg) {
        this.quantidadeEmKg = quantidadeEmKg;
    }

    public TipoMaterial getTipoMaterial() {
        return tipoMaterial;
    }

    public void setTipoMaterial(TipoMaterial tipoMaterial) {
        this.tipoMaterial = tipoMaterial;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    public LocalDateTime getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(LocalDateTime updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Estoque estoque = (Estoque) o;

        if (!Objects.equals(tipoMaterial, estoque.tipoMaterial))
            return false;
        return Objects.equals(material, estoque.material);
    }

    @Override
    public int hashCode() {
        int result = tipoMaterial != null ? tipoMaterial.hashCode() : 0;
        result = 31 * result + (material != null ? material.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Estoque{" +
                "id=" + id +
                ", quantidadeEmKg=" + quantidadeEmKg +
                ", tipoMaterial=" + tipoMaterial.getNome() +
                ", material=" + material.getNome() +
                ", createDateTime=" + createDateTime +
                ", updateDateTime=" + updateDateTime +
                '}';
    }
}
