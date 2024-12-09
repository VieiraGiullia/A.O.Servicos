package com.giulli.demo.service;

import java.util.List;

import com.giulli.demo.model.Educacao;
import com.giulli.demo.model.Experiencia;
import com.giulli.demo.model.Pessoal;
import com.giulli.demo.repository.EducacaoRepository;
import com.giulli.demo.repository.ExperienciaRepository;
import com.giulli.demo.repository.PessoalRepository;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoalService {

    @Autowired
    private PessoalRepository pessoalRepository;

    @Autowired
    private ExperienciaRepository experienciaRepository;

    @Autowired
    private EducacaoRepository educacaoRepository;

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

    public List<Experiencia> listarExperiencias(Long pessoaId) {
        Pessoal pessoa = pessoalRepository.findById(pessoaId)
                .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada"));
        return pessoa.getExperiencias();
    }

    public Experiencia adicionarExperiencia(Long pessoaId, Experiencia experiencia) {
        Pessoal pessoa = pessoalRepository.findById(pessoaId)
                .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada"));
        experiencia.setPessoa(pessoa);
        return experienciaRepository.save(experiencia);
    }

    public List<Educacao> listarEducacoes(Long pessoaId) {
        Pessoal pessoa = pessoalRepository.findById(pessoaId)
                .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada"));
        return pessoa.getEducacoes();
    }

    public Educacao adicionarEducacao(Long pessoaId, Educacao educacao) {
        Pessoal pessoa = pessoalRepository.findById(pessoaId)
                .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada"));
        educacao.setPessoa(pessoa);
        return educacaoRepository.save(educacao);
    }
}