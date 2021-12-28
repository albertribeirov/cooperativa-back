package br.com.cooperativa.dto;

import br.com.cooperativa.enumeration.TipoMensagem;
import br.com.cooperativa.model.Log;
import br.com.cooperativa.utils.TypeUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LogDTO implements Serializable {

    private String mensagem;
    private TipoMensagem tipoMensagem ;

    //Transformation DTO -> Log
    public Log dtoToLog(){
        return TypeUtils.parseToEntity(this, Log.class);
    }

}
