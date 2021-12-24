package br.com.cooperativa.enumeration;

import lombok.Getter;

@Getter
public enum TipoMensagem {
    INFO(1), ERRO(2);

    private int valor;

    TipoMensagem(int valor) {
        this.valor = valor;
    }

}
