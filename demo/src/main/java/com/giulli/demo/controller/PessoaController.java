package com.giulli.demo.controller;
import java.util.List;

import com.giulli.demo.model.Educacao;
import com.giulli.demo.model.Experiencia;
import com.giulli.demo.model.Pessoal;
import com.giulli.demo.service.PessoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
    
    @RestController
    @RequestMapping("/api/curriculo")
    public class PessoaController {
        
        @Autowired
        private PessoalService service;

        // só para testar o método
        @GetMapping("/MeuCurriculo")
        public String curriculo() {
            return "Meu currículo";
        }

        // metodos get
        @GetMapping
        public List<Pessoal> findAll() {
            return service.findAll();
        }

        @GetMapping("/{id}/experiencias")
        public ResponseEntity<List<Experiencia>> listarExperiencias(@PathVariable Long id) {
        List<Experiencia> experiencias = service.listarExperiencias(id);
        return ResponseEntity.ok(experiencias);
        }

        @GetMapping("/{id}/educacoes")
        public ResponseEntity<List<Educacao>> listarEducacoes(@PathVariable Long id) {
        List<Educacao> educacoes = service.listarEducacoes(id);
        return ResponseEntity.ok(educacoes);
        }
        // metodos post
        @PostMapping("/NovoCurriculo")
        public ResponseEntity<Pessoal> salvar(@RequestBody Pessoal pessoal) {
        Pessoal novoPessoal = service.save(pessoal);
        return ResponseEntity.ok(novoPessoal);
        }

        @PostMapping("/{id}/experiencias")
        public ResponseEntity<Experiencia> adicionarExperiencia(@PathVariable Long id, @RequestBody Experiencia experiencia) {
        Experiencia novaExperiencia = service.adicionarExperiencia(id, experiencia);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaExperiencia);
        }

        @PostMapping("/{id}/educacoes")
        public ResponseEntity<Educacao> adicionarEducacao(@PathVariable Long id, @RequestBody Educacao educacao) {
        Educacao novaEducacao = service.adicionarEducacao(id, educacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaEducacao);
        }

        @PostMapping
        public ResponseEntity<Pessoal> criarPessoa(@RequestBody Pessoal pessoa) {
            Pessoal novaPessoa = service.save(pessoa);
            return ResponseEntity.status(HttpStatus.CREATED).body(novaPessoa);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.delete(id);
            return ResponseEntity.noContent().build();   
    }
}

