package br.com.cooperativa.model;

import br.com.cooperativa.enumeration.TipoMovimentacaoEstoque;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "movimentacao_estoque")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovimentacaoEstoque extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "quantidade", nullable = false)
    private Double quantidadeEmKg;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "tipo_movimentacao", nullable = false)
    private TipoMovimentacaoEstoque tipoMovimentacaoEstoque;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_tipo_material")
    private TipoMaterial tipoMaterial;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_material")
    private Material material;

    @Column(name = "data_movimentacao", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDate dataMovimentacao;
  
    @Override
    public String toString() {
        return "MovimentacaoEstoque{" +
                "id=" + id +
                ", quantidade=" + quantidadeEmKg +
                ", tipoMovimentacaoEstoque=" + tipoMovimentacaoEstoque +
                ", tipoMaterial=" + tipoMaterial.getNome() +
                ", material=" + material.getNome() +
                ", dataMovimentacao=" + dataMovimentacao +
                ", createDateTime=" + createDateTime +
                ", updateDateTime=" + updateDateTime +
                '}';
    }
}
