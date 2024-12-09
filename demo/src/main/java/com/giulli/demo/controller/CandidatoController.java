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

import com.giulli.demo.model.Candidato;
import com.giulli.demo.service.CandidatoService;

@RestController
@RequestMapping("/candidatos")
public class CandidatoController {
    @Autowired
    private CandidatoService candidatoService;

    @PostMapping
    public ResponseEntity<Candidato> criarCandidato(@RequestBody Candidato candidato) {
        return ResponseEntity.status(HttpStatus.CREATED).body(candidatoService.salvarCandidato(candidato));
    }

    @GetMapping
    public List<Candidato> listarCandidatos() {
        return candidatoService.listarCandidatos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Candidato> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(candidatoService.buscarPorId(id));
    }
}