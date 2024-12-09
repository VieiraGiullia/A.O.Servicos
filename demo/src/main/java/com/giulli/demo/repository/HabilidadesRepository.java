package com.giulli.demo.repository;

import java.util.List;
import com.giulli.demo.model.Habilidades;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabilidadesRepository extends JpaRepository<Habilidades, Long> {
    List<Habilidades> findByPessoaId(Long pessoaId);
}
