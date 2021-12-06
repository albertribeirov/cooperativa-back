package br.com.cooperativa.model;

import br.com.cooperativa.enumeration.TipoMovimentacaoEstoque;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "venda")
public class Venda implements Serializable {

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

    @Column(name = "create_time", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createDateTime;

    @Column(name = "update_time", nullable = false)
    @UpdateTimestamp
    private LocalDateTime updateDateTime;

    public Venda() {
    }

    public Venda(String notaFiscal, Cliente cliente, TipoMovimentacaoEstoque tipoMovimentacaoEstoque, BigDecimal totalVenda, LocalDate dataVenda) {
        this.notaFiscal = notaFiscal;
        this.cliente = cliente;
        this.tipoMovimentacaoEstoque = tipoMovimentacaoEstoque;
        this.totalVenda = totalVenda;
        this.dataVenda = dataVenda;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(String notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public TipoMovimentacaoEstoque getTipoMovimentacaoEstoque() {
        return tipoMovimentacaoEstoque;
    }

    public void setTipoMovimentacaoEstoque(TipoMovimentacaoEstoque tipoMovimentacaoEstoque) {
        this.tipoMovimentacaoEstoque = tipoMovimentacaoEstoque;
    }

    public BigDecimal getTotalVenda() {
        return totalVenda;
    }

    public void setTotalVenda(BigDecimal totalVenda) {
        this.totalVenda = totalVenda;
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
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

        Venda venda = (Venda) o;

        return Objects.equals(id, venda.id);
    }

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
