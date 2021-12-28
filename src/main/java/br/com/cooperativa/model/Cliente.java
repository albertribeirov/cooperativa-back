package br.com.cooperativa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "cliente")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cliente extends BaseEntity implements Serializable  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "nome", length = 100, nullable = false)
    @NotEmpty(message = "Inserir um nome é obrigatório.")
    private String nome;

    @Column(name = "telefone_um", length = 11)
    @NotEmpty(message = "Inserir o telefone principal é obrigatório.")
    private String telefoneUm;

    @Column(name = "telefone_dois", length = 11)
    private String telefoneDois;

    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco = new Endereco();

    @Column(length = 14)
    @NotEmpty(message = "Inserir um cpf é obrigatório.")
    @CPF
    private String cpf_cnpj;

    @Column(name = "ativo", nullable = false)
    private boolean ativo;

    @Column(name = "observacao", length = 500)
    private String observacao;

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
