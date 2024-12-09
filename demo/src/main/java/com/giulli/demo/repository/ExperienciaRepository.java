package com.giulli.demo.repository;

import java.util.List;
import com.giulli.demo.model.Experiencia;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExperienciaRepository extends JpaRepository<Experiencia, Long> {
    List<Experiencia> findByEmpresaContaining(String empresa);
}