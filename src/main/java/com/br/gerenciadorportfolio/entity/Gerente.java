package com.br.gerenciadorportfolio.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Gerente  implements Serializable {
    private static final long serialVersionUID = -8098169994206334684L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String cpf;

}
