package com.br.gerenciadorportfolio.controller;


import com.br.gerenciadorportfolio.entity.Projeto;
import com.br.gerenciadorportfolio.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {

    @Autowired
    private ProjetoRepository projetoRepository;

    @PostMapping
    public ResponseEntity<Projeto> criarProjeto(@RequestBody Projeto projeto) {
        Projeto novoProjeto = projetoRepository.save(projeto);
        return ResponseEntity.ok(novoProjeto);
    }

    @GetMapping
    public List<Projeto> listar() {
        return projetoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Projeto buscar(@PathVariable Long id) {
        return projetoRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Projeto alterar(@PathVariable Long id, @RequestBody Projeto projeto) {
        projeto.setId(id);
        return projetoRepository.save(projeto);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        projetoRepository.deleteById(id);
    }

}

