package com.giulli.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.giulli.demo.model.ExperienciaProfissional;

@Repository
public interface ExperienciaProfissionalRepository extends JpaRepository<ExperienciaProfissional, Long> {
}