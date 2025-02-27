package com.araujosdev.mineNetflix.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String genero;
    private int ano;
    private double avaliacao;

    public Filme() {}

    public Filme(String titulo, String genero, int ano, double avaliacao){
        this.titulo = titulo;
        this.genero = genero;
        this.ano = ano;
        this.avaliacao = avaliacao;
    }


    public String getTitulo() { return titulo; }
    public String getGenero() { return genero; }
    public long getId() { return id; }
    public int getAno() { return ano; }
    public double getAvaliacao() { return avaliacao; }


    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setGenero(String genero) { this.genero = genero; }
    public void
    setAno(int ano) { this.ano = ano; }
    public void setId(Long id) { this.id = id; }
    public void setAvaliacao(double avaliacao) { this.avaliacao = avaliacao; }

    @Override
    public String toString() {
        return "Filme{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                ", ano=" + ano +
                ", avaliacao=" + avaliacao +
                '}';
    }
}

