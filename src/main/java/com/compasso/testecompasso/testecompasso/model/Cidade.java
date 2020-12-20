package com.compasso.testecompasso.testecompasso.model;

import com.sun.istack.NotNull;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Cidade")
public class Cidade implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    @NotBlank
    private String nome;

    @NotNull
    @NotBlank
    private String uf;

    public Cidade(@NotBlank String nome, @NotBlank String uf) {
        this.nome = nome;
        this.uf = uf;
    }

    public Cidade() {
    }

    public void setId(Long id) {        this.id = id;
    }

    public Long getId() {
        return id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cidade cidade = (Cidade) o;

        return id.equals(cidade.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Cidade{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", uf='" + uf + '\'' +
                '}';
    }
}
