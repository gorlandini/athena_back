package com.core.domain.categoria.model;




public class CategoriaBuilderUpdate {


    protected String nome;

    public CategoriaBuilderUpdate nome(String nome) {
        this.nome = nome;
        return this;
    }

    public void apply(Categoria categoria) {
        if (this.nome != null) {
            categoria.alterarNome(this.nome);
        }
    }




}


