package com.giulli.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.giulli.demo.model.Pessoal;
public interface pessoalRepository extends JpaRepository<Pessoal, Long> {

}
