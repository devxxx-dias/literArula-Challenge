package br.mauricio.literArula.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "livros")
public class Livro {
    private Long id;
    private String titulo;
    private String autor;
    private Idiomas idiomas;
    private String downloads;
    //provalvemente devera ser um double 1011.0
}
