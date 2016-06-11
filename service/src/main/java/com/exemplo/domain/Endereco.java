package com.exemplo.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

@Entity
@Data
public class Endereco {

    @Id
    @Column(updatable = false, nullable = false)
    @Size(min = 0, max = 50)
    private String id;

    private String lougradouro;

    private String complemento;

    private Integer cep;

    @ManyToOne
    private Usuario usuario;

}
