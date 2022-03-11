package com.AppCha.appCha.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.persistence.Table;
import javax.persistence.Id;


@Entity
@Table(name="tipo")
public class Tipo {

    @Id
    private long idtipo;

    @NotEmpty
    private String nome;

    public long getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(long idtipo) {
        this.idtipo = idtipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
