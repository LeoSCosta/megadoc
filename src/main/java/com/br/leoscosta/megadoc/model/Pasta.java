package com.br.leoscosta.megadoc.model;

import jakarta.persistence.*;
import org.hibernate.annotations.SQLRestriction;

import java.time.LocalDateTime;

@Entity
@Table
@SQLRestriction("excluido = false")
public class Pasta extends EntidadeBase{
    @ManyToOne
    private Devedor devedor;

}
