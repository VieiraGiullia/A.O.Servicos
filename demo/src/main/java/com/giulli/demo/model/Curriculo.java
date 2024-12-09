package com.giulli.demo.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Curriculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private String skills;

    @ManyToOne
    @JoinColumn(name = "candidato_id")
    private Candidato candidato;

    @OneToMany(mappedBy = "curriculo", cascade = CascadeType.PERSIST)
    @JsonIgnore
    private List<ExperienciaProfissional> experiencias = new ArrayList<>();
}