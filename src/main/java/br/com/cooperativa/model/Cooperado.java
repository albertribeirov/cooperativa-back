package br.com.cooperativa.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Cooperado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "nome_completo", length = 100, nullable = false)
    private String nomeCompleto;

    @Column(name = "telefone_um", length = 11)
    private String telefoneUm;

    @Column(name = "telefone_dois", length = 11)
    private String telefoneDois;

    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco = new Endereco();

    @Column(length = 11)
    private String cpf;

    @Column(name = "ativo", nullable = false)
    private boolean ativo;

    @Column(name = "observacao", length = 500)
    private String observacao;

    @Column(name = "create_time", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createDateTime;

    @Column(name = "update_time", nullable = false)
    @UpdateTimestamp
    private LocalDateTime updateDateTime;

    public Cooperado() {
    }

    public Cooperado(String nomeCompleto, String telefoneUm, String telefoneDois, Endereco endereco, String cpf, boolean ativo, String observacao) {
        this.nomeCompleto = nomeCompleto;
        this.telefoneUm = telefoneUm;
        this.telefoneDois = telefoneDois;
        this.endereco = endereco;
        this.cpf = cpf;
        this.ativo = ativo;
        this.observacao = observacao;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
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

        Cooperado cooperado = (Cooperado) o;

        if (!Objects.equals(id, cooperado.id)) return false;
        return Objects.equals(cpf, cooperado.cpf);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (cpf != null ? cpf.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Cooperado{" +
                "id=" + id +
                ", nomeCompleto='" + nomeCompleto + '\'' +
                ", telefoneUm='" + telefoneUm + '\'' +
                ", telefoneDois='" + telefoneDois + '\'' +
                ", endereco=" + endereco +
                ", cpf='" + cpf + '\'' +
                ", ativo=" + ativo +
                ", observacao='" + observacao + '\'' +
                ", createDateTime=" + createDateTime +
                ", updateDateTime=" + updateDateTime +
                '}';
    }
}
