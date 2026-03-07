package com.core.domain.categoria.model;



import com.core.sk.identifiers.CategoriaId;

public class CategoriaBuilder {

    protected CategoriaId id;
    protected String nome;

    public CategoriaBuilder nome(String nome) {
        this.nome = nome;
        return this;
    }



    public Categoria build() {
        this.id = CategoriaId.generate();
        return new Categoria(this);
    }
}

