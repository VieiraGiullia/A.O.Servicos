package main.java.com.giulli.demo.model;

import javax.annotation.processing.Generated;

@Entity
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String empresa;
    private String cargo;
    private String dataDeInicio;
    private String dataDeFim;
    private String descricao;
}
