package com.br.gerenciadorportfolio.controller;


import com.br.gerenciadorportfolio.entity.Gerente;
import com.br.gerenciadorportfolio.repository.GerenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gerentes")
public class GerenteController {

    @Autowired
    private GerenteRepository getenteRepository;

    @PostMapping
    public ResponseEntity<Gerente> criarGerente(@RequestBody Gerente gerente) {
        Gerente novoGerente = getenteRepository.save(gerente);
        return ResponseEntity.ok(novoGerente);
    }

    @GetMapping
    public List<Gerente> listar() {
        return getenteRepository.findAll();
    }

    @GetMapping("/{id}")
    public Gerente buscar(@PathVariable Long id) {
        return getenteRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Gerente alterar(@PathVariable Long id, @RequestBody Gerente gerente) {
        gerente.setId(id);
        return getenteRepository.save(gerente);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        getenteRepository.deleteById(id);
    }

}

