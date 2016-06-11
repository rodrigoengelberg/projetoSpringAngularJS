package com.exemplo.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Getter
@Setter
@Data
public class Usuario {

    @Id
    @Column(updatable = false, nullable = false)
    @Size(min = 0, max = 50)
    private String id;

    private String nome;

    private Integer matricula;

    @Email
    @Size(min = 0, max = 50)
    private String email;

    @Size(min = 0, max = 500)
    private String password;

    @OneToMany
    private List<Endereco> endereco;

}
