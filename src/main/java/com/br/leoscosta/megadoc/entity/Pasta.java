package com.br.leoscosta.megadoc.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.SQLRestriction;

@Entity
@Table
@SQLRestriction("excluido = false")
public class Pasta extends EntidadeBase{
    @ManyToOne
    private Devedor devedor;

}
