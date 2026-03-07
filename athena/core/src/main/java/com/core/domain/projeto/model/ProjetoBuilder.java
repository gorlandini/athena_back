package com.core.domain.projeto.model;



import com.core.sk.identifiers.ProjetoId;

public class ProjetoBuilder {

    protected ProjetoId id;
    protected String nomeProjeto;
    protected String nomeProfessor;
    protected int termo;
    protected String curso;

    public ProjetoBuilder nomeProjeto(String nomeProjeto) {
        this.nomeProjeto = nomeProjeto;
        return this;
    }

    public ProjetoBuilder nomeProf(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
        return this;
    }

    public ProjetoBuilder termo(int termo) {
        this.termo = termo;
        return this;
    }

    public ProjetoBuilder curso(String curso) {
        this.curso = curso;
        return this;
    }

    public Projeto build() {
        this.id = ProjetoId.generate();
        return new Projeto(this);
    }
}

