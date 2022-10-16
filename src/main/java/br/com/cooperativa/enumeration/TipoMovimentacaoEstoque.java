package br.com.cooperativa.enumeration;

import lombok.Getter;

@Getter
public enum TipoMovimentacaoEstoque {
    ENTRADA(1), SAIDA(2), AJUSTE(3);

    final int valor;

    TipoMovimentacaoEstoque(int valor) {
        this.valor = valor;
    }

}
