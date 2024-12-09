package com.giulli.demo.model;

import jakarta.persistence.*;

@Entity
public class Educacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String instituicao;
    private String curso;
    private String anoDeConclusao;

    public Long getId() {
        return id;
    }
    public String getInstituicao() {
        return instituicao;
    }
    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }
    public String getCurso() {
        return curso;
    }
    public void setCurso(String curso) {
        this.curso = curso;
    }
    public String getAnoDeConclusao() {
        return anoDeConclusao;
    }
    public void setAnoDeConclusao(String anoDeConclusao) {
        this.anoDeConclusao = anoDeConclusao;
    }


}
