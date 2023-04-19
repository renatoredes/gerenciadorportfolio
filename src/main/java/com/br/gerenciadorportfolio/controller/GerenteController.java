package com.br.gerenciadorportfolio.controller;

import com.br.gerenciadorportfolio.entity.Gerente;
import com.br.gerenciadorportfolio.service.GerenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/gerentes")
public class GerenteController {
    @Autowired
    private GerenteService gerenteService;

    @PostMapping
    public ResponseEntity<Gerente> criarGerente(@RequestBody Gerente gerente) {
        Gerente novoGerente = gerenteService.salvarGerente(gerente);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoGerente);
    }

    @GetMapping("/gerente")
    public String listar(Model m) {

        m.addAttribute("gerente", gerenteService.listarGerentes());
        return "ListarGerentes";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Gerente> buscarGerente(@PathVariable Long id) {
        Optional<Gerente> gerente = gerenteService.buscarGerente(id);
        if (gerente.isPresent()) {
            return ResponseEntity.ok(gerente.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Gerente> atualizarGerente(@PathVariable Long id, @RequestBody Gerente gerente) {
        Optional<Gerente> gerenteExistente = gerenteService.buscarGerente(id);
        if (gerenteExistente.isPresent()) {
            Gerente gerentetoAtualizado = gerenteService.salvarGerente(gerente);
            return ResponseEntity.ok(gerentetoAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirGerente(@PathVariable Long id) {
        gerenteService.excluirGerente(id);
        return ResponseEntity.noContent().build();
    }

}

