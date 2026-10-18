package com.br.leoscosta.megadoc.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLRestriction;


@Entity
@Table
@Getter@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@SQLRestriction("excluido = false")
public class Devedor extends EntidadeBase{

    private String nome;
    private String documento;


    public Devedor(String nome, String documento) {
        this.nome = nome;
        this.documento = documento;
    }

}
