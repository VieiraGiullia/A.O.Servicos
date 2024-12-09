package com.giulli.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.giulli.demo.model.Pessoal;

public interface PessoalRepository extends JpaRepository<Pessoal, Long> {
    List<Pessoal> findByNomeContaining(String nome);
}