package com.br.gerenciadorportfolio.entity;

import com.br.gerenciadorportfolio.entity.enums.StatusProjeto;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Projeto implements Serializable {
    private static final long serialVersionUID = -8098169994206334684L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String dataInicio;
    @ManyToOne
    @JoinColumn(name = "gerente_id")
    private Gerente gerenteResponsavel;
    private String previsaoTermino;
    private String dataRealTermino;
    private BigDecimal orcamentoTotal;
    private String descricao;
    @Enumerated(EnumType.STRING)
    private StatusProjeto status;

}
