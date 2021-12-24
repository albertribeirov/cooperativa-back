package br.com.cooperativa.model;

import br.com.cooperativa.enumeration.TipoMensagem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Log extends BaseEntity implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "mensagem", nullable = false, length = 300)
    private String mensagem;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_mensagem", nullable = false, length = 20)
    private TipoMensagem tipoMensagem;

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
                ", data=" + createDateTime +
                ", mensagem='" + mensagem + '\'' +
                ", tipoMensagem=" + tipoMensagem +
                '}';
    }
}
