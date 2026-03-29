package com.core.domain.aluno.model;

import static java.util.Objects.requireNonNull;

public class AlunoBuilderUpdate {

    protected String nome;
    protected String matricula;

    public AlunoBuilderUpdate nome(String nome) {
        this.nome = nome;
        return this;
    }

    public AlunoBuilderUpdate matricula(String matricula) {
        this.matricula = matricula;
        return this;
    }

    public void apply(AlunoBuilderUpdate builder) {
        requireNonNull(builder);

        if (builder.nome != null) {
            nome(builder.nome);
        }

        if (builder.matricula != null) {
            matricula(builder.matricula);
        }
    }

}
