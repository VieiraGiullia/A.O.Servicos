package com.giulli.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.giulli.demo.model.Candidato;

@Repository
public interface CandidatoRepository extends JpaRepository<Candidato, Long> {
}
