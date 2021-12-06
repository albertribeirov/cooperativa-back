package br.com.cooperativa.model;

import br.com.cooperativa.enumeration.TipoMensagem;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Log implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime data;

    @Column(name = "mensagem", nullable = false, length = 300)
    private String mensagem;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_mensagem", nullable = false, length = 20)
    private TipoMensagem tipoMensagem;

    public Log() {
    }

    public Log(String mensagem, TipoMensagem tipoMensagem) {
        this.mensagem = mensagem;
        this.tipoMensagem = tipoMensagem;
    }

    public Log(LocalDateTime data, TipoMensagem tipoMensagem, String mensagem) {
        this.data = data;
        this.tipoMensagem = tipoMensagem;
        this.mensagem = mensagem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getTipoMensagem() {
        return tipoMensagem.name();
    }

    public void setTipoMensagem(TipoMensagem tipoMensagem) {
        this.tipoMensagem = tipoMensagem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Log log = (Log) o;

        if (!Objects.equals(mensagem, log.mensagem)) return false;
        return tipoMensagem == log.tipoMensagem;
    }

    @Override
    public int hashCode() {
        int result = mensagem != null ? mensagem.hashCode() : 0;
        result = 31 * result + (tipoMensagem != null ? tipoMensagem.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", data=" + data +
                ", mensagem='" + mensagem + '\'' +
                ", tipoMensagem=" + tipoMensagem +
                '}';
    }
}
