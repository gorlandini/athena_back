package com.core.domain.aluno.model;

import com.core.sk.identifiers.AlunoId;

public class AlunoBuilder {

    protected AlunoId id;
    protected String nome;
    protected String matricula;

    public AlunoBuilder nome(String nome) {
        this.nome = nome;
        return this;
    }

    public AlunoBuilder matricula(String matricula) {
        this.matricula = matricula;
        return this;
    }

    public Aluno build() {
        this.id = AlunoId.generate();
        return new Aluno(this);
    }
}
