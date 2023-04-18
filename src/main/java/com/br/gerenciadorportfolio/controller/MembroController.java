package com.br.gerenciadorportfolio.controller;

import com.br.gerenciadorportfolio.entity.Membro;
import com.br.gerenciadorportfolio.entity.Projeto;
import com.br.gerenciadorportfolio.service.MembroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projetos/{projetoId}/membros")
public class MembroController {
    @Autowired
    private MembroService membroService;

    @PostMapping
    public ResponseEntity<Membro> cadastrarMembro(@PathVariable Long projetoId, @RequestBody Membro membro) {
        Projeto projeto = new Projeto();
        projeto.setId(projetoId);
        membro.setProjeto(projeto);
        Membro novoMembro = membroService.cadastrarMembro(membro);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoMembro);
    }

    @PutMapping("/{membroId}")
    public ResponseEntity<Membro> atualizarMembro(@PathVariable Long projetoId, @PathVariable Long membroId, @RequestBody Membro membro) {
        Projeto projeto = new Projeto();
        projeto.setId(projetoId);
        membro.setProjeto(projeto);
        Membro membroAtualizado = membroService.atualizarMembro(membroId, membro);
        return ResponseEntity.ok(membroAtualizado);
    }

    @DeleteMapping("/{membroId}")
    public ResponseEntity<Void> excluirMembro(@PathVariable Long projetoId, @PathVariable Long membroId) {
        membroService.excluirMembro(membroId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Membro>> listarMembrosPorProjeto(@PathVariable Long projetoId) {
        List<Membro> membros = membroService.listarMembrosPorProjeto(projetoId);
        return ResponseEntity.ok(membros);
    }

}
