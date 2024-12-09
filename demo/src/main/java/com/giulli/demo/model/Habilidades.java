package com.giulli.demo.model;

import jakarta.persistence.*;

@Entity
public class Habilidades {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String habilidade;

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoal pessoa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHabilidade() {
        return habilidade;
    }

    public void setHabilidade(String habilidade) {
        this.habilidade = habilidade;
    }

    public Pessoal getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoal pessoa) {
        this.pessoa = pessoa;
    }
}
