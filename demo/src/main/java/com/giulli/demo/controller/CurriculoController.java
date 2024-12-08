import java.util.List;

import main.java.com.giulli.demo.model.Pessoal;
import main.java.com.giulli.demo.service.PessoalService;
import jakarta.validation.Valid;
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

        @GetMapping("/curriculo")
        public String curriculo() {
            return "Meu currículo";
        }

        @PostMapping("/NovoCurriculo")
        public ResponseEntity<Pessoal> salvar(@Valid @RequestBody Pessoal pessoal) {
        Pessoal novoPessoal = pessoalService.salvar(pessoal);
        return ResponseEntity.ok(novoPessoal);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deletar(@PathVariable Long id) {
        pessoalService.deletar(id);
            return ResponseEntity.noContent().build();   
    }
}

