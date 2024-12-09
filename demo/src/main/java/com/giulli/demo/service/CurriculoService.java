package com.giulli.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giulli.demo.model.Curriculo;
import com.giulli.demo.repository.CurriculoRepository;

@Service
public class CurriculoService {
    @Autowired
    private CurriculoRepository curriculoRepository;

    public Curriculo salvarCurriculo(Curriculo curriculo) {
        return curriculoRepository.save(curriculo);
    }

    public List<Curriculo> listarCurriculos() {
        return curriculoRepository.findAll();
    }

    public Curriculo buscarPorId(Long id) {
        return curriculoRepository.findById(id).orElseThrow(() -> new RuntimeException("Currículo não encontrado"));
    }
}
