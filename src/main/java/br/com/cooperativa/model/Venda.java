package br.com.cooperativa.model;

import br.com.cooperativa.enumeration.TipoMovimentacaoEstoque;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "venda")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Venda extends BaseEntity implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nota_fiscal", length = 10, nullable = false)
    private String notaFiscal;

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "tipo_movimentacao", nullable = false)
    private TipoMovimentacaoEstoque tipoMovimentacaoEstoque;

    @Column(name = "total_venda", precision = 13, scale = 2, nullable = false)
    private BigDecimal totalVenda;

    @Column(name = "data_venda", nullable = false)
    private LocalDate dataVenda;

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Venda{" +
                "id=" + id +
                ", notaFiscal='" + notaFiscal + '\'' +
                ", cliente=" + cliente +
                ", tipoMovimentacaoEstoque=" + tipoMovimentacaoEstoque +
                ", totalVenda=" + totalVenda +
                ", dataVenda=" + dataVenda +
                ", createDateTime=" + createDateTime +
                ", updateDateTime=" + updateDateTime +
                '}';
    }
}
