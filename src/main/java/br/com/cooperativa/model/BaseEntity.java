package br.com.cooperativa.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
@ToString
public class BaseEntity {

    @Column(name = "create_date")
    @CreationTimestamp
    protected LocalDateTime createDateTime;

    @Column(name = "update_date")
    @UpdateTimestamp
    protected LocalDateTime updateDateTime;

    @Column(name = "deleted")
    protected Boolean deleted = Boolean.FALSE;

}
