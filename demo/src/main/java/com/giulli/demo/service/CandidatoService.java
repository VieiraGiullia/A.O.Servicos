package com.giulli.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giulli.demo.model.Candidato;
import com.giulli.demo.repository.CandidatoRepository;

@Service
public class CandidatoService {
    @Autowired
    private CandidatoRepository candidatoRepository;

    public Candidato salvarCandidato(Candidato candidato) {
        return candidatoRepository.save(candidato);
    }

    public List<Candidato> listarCandidatos() {
        return candidatoRepository.findAll();
    }

    public Candidato buscarPorId(Long id) {
        return candidatoRepository.findById(id).orElseThrow(() -> new RuntimeException("Candidato não encontrado"));
    }
}
