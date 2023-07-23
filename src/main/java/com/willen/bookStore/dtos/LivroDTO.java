package com.willen.bookStore.dtos;

import com.willen.bookStore.domain.Livro;

public class LivroDTO {

    private Integer id;
    private String titulo;

    public LivroDTO() {
    }

    public LivroDTO(Livro obj) {
        this.id = obj.getId();
        this.titulo = obj.getTitulo();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
