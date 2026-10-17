package com.br.leoscosta.megadoc.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLRestriction;

import java.time.LocalDateTime;

@Entity
@Table
@SQLRestriction("excluido = false")
public class Devedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String documento;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime dataCadastro;

    @Column(nullable = false)
    private boolean excluido = false;

    public Devedor(String nome, String documento) {
        this.nome = nome;
        this.documento = documento;
    }

    public Devedor() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public boolean isExcluido() {
        return excluido;
    }

    public void setExcluido(boolean excluido) {
        this.excluido = excluido;
    }

    @Override
    public String toString() {
        return "Devedor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", documento='" + documento + '\'' +
                ", excluido=" + excluido +
                '}';
    }
}
