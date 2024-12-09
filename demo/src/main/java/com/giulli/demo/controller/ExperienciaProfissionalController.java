package com.giulli.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.giulli.demo.model.ExperienciaProfissional;
import com.giulli.demo.service.ExperienciaProfissionalService;

@RestController
@RequestMapping("/experiencias")
public class ExperienciaProfissionalController {
    @Autowired
    private ExperienciaProfissionalService experienciaService;

    @PostMapping
    public ResponseEntity<ExperienciaProfissional> criarExperiencia(@RequestBody ExperienciaProfissional experiencia) {
        return ResponseEntity.status(HttpStatus.CREATED).body(experienciaService.salvarExperiencia(experiencia));
    }

    @GetMapping
    public List<ExperienciaProfissional> listarExperiencias() {
        return experienciaService.listarExperiencias();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExperienciaProfissional> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(experienciaService.buscarPorId(id));
    }
}
