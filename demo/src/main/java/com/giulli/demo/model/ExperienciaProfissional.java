package com.giulli.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ExperienciaProfissional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cargo;
    private String empresa;
    private Integer anoInicio;
    private Integer anoFim;

    @ManyToOne
    @JoinColumn(name = "curriculo_id")
    private Curriculo curriculo;
}

