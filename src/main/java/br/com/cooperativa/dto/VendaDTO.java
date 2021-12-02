package br.com.cooperativa.dto;

import br.com.cooperativa.enumeration.TipoMovimentacaoEstoque;
import br.com.cooperativa.model.Cliente;
import br.com.cooperativa.model.Venda;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public class VendaDTO implements Serializable {

    private String notaFiscal;
    private Cliente cliente;
    private TipoMovimentacaoEstoque tipoMovimentacaoEstoque;
    private BigDecimal totalVenda;
    private LocalDate dataVenda;

    public VendaDTO() {
    }

    public Venda dtoToVenda(){
        return new Venda(this.notaFiscal, this.cliente, this.tipoMovimentacaoEstoque, this.totalVenda, this.dataVenda);
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
}
