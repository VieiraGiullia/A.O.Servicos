package com.giulli.demo.repository;

import java.util.List;
import com.giulli.demo.model.Educacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EducacaoRepository extends JpaRepository<Educacao, Long> {
    List<Educacao> findByInstituicaoContaining(String instituicao);
}
