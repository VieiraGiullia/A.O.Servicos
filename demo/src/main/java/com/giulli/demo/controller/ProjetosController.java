package com.giulli.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.giulli.demo.model.Experiencia;
import com.giulli.demo.model.Projetos;
import com.giulli.demo.repository.ExperienciaRepository;
import com.giulli.demo.repository.ProjetosRepository;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/projetos")
public class ProjetosController {

    @Autowired
    private ProjetosRepository projetosRepository;

    @Autowired
    private ExperienciaRepository experienciaRepository;

    @PostMapping("/{experienciaId}")
    public ResponseEntity<Projetos> adicionarProjeto(@PathVariable Long experienciaId, @RequestBody Projetos projeto) {
        Experiencia experiencia = experienciaRepository.findById(experienciaId)
                .orElseThrow(() -> new EntityNotFoundException("Experiência não encontrada"));
        projeto.setExperiencia(experiencia);
        Projetos novoProjeto = projetosRepository.save(projeto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoProjeto);
    }

    @GetMapping("/{experienciaId}")
    public ResponseEntity<List<Projetos>> listarProjetos(@PathVariable Long experienciaId) {
        List<Projetos> projetos = projetosRepository.findByExperienciaId(experienciaId);
        return ResponseEntity.ok(projetos);
    }
}

