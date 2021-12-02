package br.com.cooperativa.dto;

import br.com.cooperativa.enumeration.TipoMensagem;
import br.com.cooperativa.model.Log;

import java.io.Serializable;

public class LogDTO implements Serializable {

    private String mensagem;
    private TipoMensagem tipoMensagem ;

    public LogDTO() {
    }

    //Transformation DTO -> Log
    public Log dtoToLog(){
        return new Log(this.mensagem, this.tipoMensagem);
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public TipoMensagem getTipoMensagem() {
        return tipoMensagem;
    }

    public void setTipoMensagem(TipoMensagem tipoMensagem) {
        this.tipoMensagem = tipoMensagem;
    }
}
