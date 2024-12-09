package com.giulli.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giulli.demo.model.ExperienciaProfissional;
import com.giulli.demo.repository.ExperienciaProfissionalRepository;

@Service
public class ExperienciaProfissionalService {
    @Autowired
    private ExperienciaProfissionalRepository experienciaRepository;

    public ExperienciaProfissional salvarExperiencia(ExperienciaProfissional experiencia) {
        return experienciaRepository.save(experiencia);
    }

    public List<ExperienciaProfissional> listarExperiencias() {
        return experienciaRepository.findAll();
    }

    public ExperienciaProfissional buscarPorId(Long id) {
        return experienciaRepository.findById(id).orElseThrow(() -> new RuntimeException("Experiência não encontrada"));
    }
}
