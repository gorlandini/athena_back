package com.core.domain.categoria.model;


public class CategoriaBuilder {


    protected String nome;

    public CategoriaBuilder nome(String nome) {
        this.nome = nome;
        return this;
    }



    public Categoria build() {

        return new Categoria(this);
    }
}

