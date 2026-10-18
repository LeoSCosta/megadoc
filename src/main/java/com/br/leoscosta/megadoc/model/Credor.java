package com.br.leoscosta.megadoc.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter@Setter
public class Credor extends EntidadeBase{
    private String nome;
}
