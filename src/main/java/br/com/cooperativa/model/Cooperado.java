package br.com.cooperativa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cooperado extends BaseEntity implements Serializable {

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
    private Boolean ativo;

    @Column(name = "observacao", length = 500)
    private String observacao;

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
                ", createDateTime=" + updateDateTime +
                ", updateDateTime=" + createDateTime +
                '}';
    }
}
