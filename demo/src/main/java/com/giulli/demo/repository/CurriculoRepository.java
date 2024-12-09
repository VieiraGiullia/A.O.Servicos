package com.giulli.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.giulli.demo.model.Curriculo;

@Repository
public interface CurriculoRepository extends JpaRepository<Curriculo, Long> {
}
