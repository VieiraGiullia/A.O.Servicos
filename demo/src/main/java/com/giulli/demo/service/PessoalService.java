package main.java.com.giulli.demo.service;

import java.util.List;

import main.java.com.giulli.demo.model.Pessoal;
import main.java.com.giulli.demo.repository.PessoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoalService {

    @Autowired
    private PessoalRepository repository;

    public List<Pessoal> findAll() {
        return pessoalRepository.findAll();
    }

    public Pessoal save(Pessoal pessoal) {
        return pessoalRepository.save(pessoal);
    }

    public Pessoal findById(Long id) {
        return pessoalRepository.findById(id).orElseThrow(() -> new RuntimeException("Registro não encontrado"));
    }

    public void delete(Long id) {
        pessoalRepository.deleteById(id);
    }
}