package com.compasso.testecompasso.testecompasso.model.dto;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class CidadeDto implements Serializable {


    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    private String uf;

    public CidadeDto() {
    }

    public CidadeDto(@NotBlank String nome, @NotBlank String uf) {
        this.nome = nome;
        this.uf = uf;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}
