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

import com.giulli.demo.model.Curriculo;
import com.giulli.demo.service.CurriculoService;

@RestController
@RequestMapping("/curriculos")
public class CurriculoController {
    @Autowired
    private CurriculoService curriculoService;

    @PostMapping
    public ResponseEntity<Curriculo> criarCurriculo(@RequestBody Curriculo curriculo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(curriculoService.salvarCurriculo(curriculo));
    }

    @GetMapping
    public List<Curriculo> listarCurriculos() {
        return curriculoService.listarCurriculos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curriculo> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(curriculoService.buscarPorId(id));
    }
}
