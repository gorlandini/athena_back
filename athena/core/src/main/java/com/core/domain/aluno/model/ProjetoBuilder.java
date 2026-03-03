package com.core.domain.aluno.model;



import com.core.sk.identifiers.ProjetoId;

public class ProjetoBuilder {

    protected ProjetoId id;
    protected String nomeProjeto;
    protected String nomeProfessor;

    public ProjetoBuilder nomeProjeto(String nomeProjeto) {
        this.nomeProjeto = nomeProjeto;
        return this;
    }

    public ProjetoBuilder nomeProf(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
        return this;
    }

    public Projeto build() {
        this.id = ProjetoId.generate();
        return new Projeto(this);
    }
}

