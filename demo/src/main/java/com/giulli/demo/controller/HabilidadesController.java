package com.giulli.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.giulli.demo.model.Habilidades;
import com.giulli.demo.model.Pessoal;
import com.giulli.demo.repository.HabilidadesRepository;
import com.giulli.demo.repository.PessoalRepository;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/habilidades")
public class HabilidadesController {

    @Autowired
    private HabilidadesRepository habilidadesRepository;

    @Autowired
    private PessoalRepository pessoaRepository;

    @PostMapping("/{pessoaId}")
    public ResponseEntity<Habilidades> adicionarHabilidade(@PathVariable Long pessoaId, @RequestBody Habilidades habilidade) {
        Pessoal pessoa = pessoaRepository.findById(pessoaId)
                .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada"));
        habilidade.setPessoa(pessoa);
        Habilidades novaHabilidade = habilidadesRepository.save(habilidade);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaHabilidade);
    }

    @GetMapping("/{pessoaId}")
    public ResponseEntity<List<Habilidades>> listarHabilidades(@PathVariable Long pessoaId) {
        List<Habilidades> habilidades = habilidadesRepository.findByPessoaId(pessoaId);
        return ResponseEntity.ok(habilidades);
    }
}
