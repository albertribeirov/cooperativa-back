package br.com.cooperativa.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "telefone_um", length = 11)
    private String telefoneUm;

    @Column(name = "telefone_dois", length = 11)
    private String telefoneDois;

    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco = new Endereco();

    @Column(length = 14)
    private String cpf_cnpj;

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

    public Cliente() {
    }

    public Cliente(String nome, String telefoneUm, String telefoneDois, Endereco endereco, String cpf_cnpj, boolean ativo, String observacao) {
        this.nome = nome;
        this.telefoneUm = telefoneUm;
        this.telefoneDois = telefoneDois;
        this.endereco = endereco;
        this.cpf_cnpj = cpf_cnpj;
        this.ativo = ativo;
        this.observacao = observacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

        Cliente cliente = (Cliente) o;

        return Objects.equals(cpf_cnpj, cliente.cpf_cnpj);
    }

    @Override
    public int hashCode() {
        return cpf_cnpj != null ? cpf_cnpj.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", telefoneUm='" + telefoneUm + '\'' +
                ", telefoneDois='" + telefoneDois + '\'' +
                ", endereco=" + endereco +
                ", cpf_cnpj='" + cpf_cnpj + '\'' +
                ", ativo=" + ativo +
                ", observacao='" + observacao + '\'' +
                ", createDateTime=" + createDateTime +
                ", updateDateTime=" + updateDateTime +
                '}';
    }
}
