package com.giulli.demo.controller;
import java.util.List;

import com.giulli.demo.model.Pessoal;
import com.giulli.demo.service.PessoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
    
    @RestController
    @RequestMapping("/api/curriculo")
    public class CurriculoController {
        
        @Autowired
        private PessoalService service;

        @GetMapping
        public List<Pessoal> findAll() {
            return service.findAll();
        }

        @GetMapping("/MeuCurriculo")
        public String curriculo() {
            return "Meu currículo";
        }

        @PostMapping("/NovoCurriculo")
        public ResponseEntity<Pessoal> salvar(@RequestBody Pessoal pessoal) {
        Pessoal novoPessoal = service.save(pessoal);
        return ResponseEntity.ok(novoPessoal);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.delete(id);
            return ResponseEntity.noContent().build();   
    }
}

