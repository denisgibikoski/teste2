package com.compasso.testecompasso.testecompasso.model.dto;

import com.compasso.testecompasso.testecompasso.model.Cidade;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDate;

public class ClienteDto implements Serializable {

    private Long id;

    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank
    private String sexo;

    private LocalDate nascimento;

    private Integer idade;

    private CidadeDto cidadeDto;

    public ClienteDto() {
    }

    public ClienteDto(String nome, String sobrenome, String sexo, LocalDate nascimento, Integer idade, CidadeDto cidadeDto) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.sexo = sexo;
        this.nascimento = nascimento;
        this.idade = idade;
        this.cidadeDto = cidadeDto;
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

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public CidadeDto getCidade() {
        return cidadeDto;
    }

    public void setCidade(CidadeDto cidadeDto) {
        this.cidadeDto = cidadeDto;
    }
}
