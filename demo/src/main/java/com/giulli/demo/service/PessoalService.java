package com.giulli.demo.service;

import java.util.List;

import com.giulli.demo.model.Pessoal;
import com.giulli.demo.repository.pessoalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoalService {

    @Autowired
    private pessoalRepository repository;

    public List<Pessoal> findAll() {
        return repository.findAll();
    }

    public Pessoal save(Pessoal pessoal) {
        return repository.save(pessoal);
    }

    public Pessoal findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Registro não encontrado"));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}