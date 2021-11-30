package br.com.cooperativa.enumeration;

public enum TipoMovimentacaoEstoque {
    ENTRADA(1), SAIDA(2), AJUSTE(3);

    int valor;

    TipoMovimentacaoEstoque(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
