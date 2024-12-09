package com.giulli.demo.repository;

import java.util.List;
import com.giulli.demo.model.Projetos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetosRepository extends JpaRepository<Projetos, Long> {
    List<Projetos> findByExperienciaId(Long experienciaId);
}
