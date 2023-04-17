package com.br.gerenciadorportfolio.service;

import com.br.gerenciadorportfolio.entity.Projeto;
import com.br.gerenciadorportfolio.entity.enums.StatusProjeto;
import com.br.gerenciadorportfolio.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetoService{
    @Autowired
    private ProjetoRepository projetoRepository;

    public List<Projeto> listarProjetos() {
        return projetoRepository.findAll();
    }

    public Optional<Projeto> buscarProjeto(Long id) {
        return projetoRepository.findById(id);
    }

    public Projeto salvarProjeto(Projeto projeto) {
        return projetoRepository.save(projeto);
    }
    public void excluirProjeto(Long id) {
        Optional<Projeto> optionalProjeto = projetoRepository.findById(id);

        if (optionalProjeto.isPresent()) {
            Projeto projeto = optionalProjeto.get();

            if (projeto.getStatus() == StatusProjeto.INICIADO ||
                    projeto.getStatus() == StatusProjeto.EM_ANDAMENTO ||
                    projeto.getStatus() == StatusProjeto.ENCERRADO) {
                throw new RuntimeException("Não é possível excluir um projeto com o status " + projeto.getStatus());
            }
            projetoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Projeto não encontrado");
        }
    }
}
