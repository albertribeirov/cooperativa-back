package br.com.cooperativa.dto;

import br.com.cooperativa.enumeration.TipoMovimentacaoEstoque;
import br.com.cooperativa.model.Cliente;
import br.com.cooperativa.model.Venda;
import br.com.cooperativa.utils.TypeUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VendaDTO implements Serializable {

    private String notaFiscal;
    private Cliente cliente;
    private TipoMovimentacaoEstoque tipoMovimentacaoEstoque;
    private BigDecimal totalVenda;
    private LocalDate dataVenda;

    public Venda dtoToVenda(){
        return TypeUtils.parseToEntity(this, Venda.class);
    }

}
