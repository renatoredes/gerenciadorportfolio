package com.br.gerenciadorportfolio.controller;


import com.br.gerenciadorportfolio.entity.Projeto;
import com.br.gerenciadorportfolio.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @PostMapping
    public ResponseEntity<Projeto> criarProjeto(@RequestBody Projeto projeto) {
        Projeto novoProjeto = projetoService.salvarProjeto(projeto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoProjeto);
    }

    @GetMapping
    public List<Projeto> listar() {
        return projetoService.listarProjetos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Projeto> buscarProjeto(@PathVariable Long id) {
        Optional<Projeto> projeto = projetoService.buscarProjeto(id);
        if (projeto.isPresent()) {
            return ResponseEntity.ok(projeto.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Projeto> atualizarProjeto(@PathVariable Long id, @RequestBody Projeto projeto) {
        Optional<Projeto> projetoExistente = projetoService.buscarProjeto(id);
        if (projetoExistente.isPresent()) {
            Projeto projetoAtualizado = projetoService.salvarProjeto(projeto);
            return ResponseEntity.ok(projetoAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirProjeto(@PathVariable Long id) {
        projetoService.excluirProjeto(id);
        return ResponseEntity.noContent().build();
    }
}

