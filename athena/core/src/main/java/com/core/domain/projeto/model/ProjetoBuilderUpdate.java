package com.core.domain.projeto.model;

import com.core.sk.identifiers.AlunoId;

import java.util.List;
import java.util.UUID;

public class ProjetoBuilderUpdate {

    protected String nomeProjeto;
    protected String nomeProfessor;
    protected Integer termo;
    protected String curso;
    protected List<AlunoId> alunos;

    public ProjetoBuilderUpdate alunos(List<AlunoId> alunos) {
        this.alunos = alunos;
        return this;
    }

    public ProjetoBuilderUpdate nomeProjeto(String nomeProjeto) {
        this.nomeProjeto = nomeProjeto;
        return this;
    }

    public ProjetoBuilderUpdate nomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
        return this;
    }

    public ProjetoBuilderUpdate termo(Integer termo) {
        this.termo = termo;
        return this;
    }

    public ProjetoBuilderUpdate curso(String curso) {
        this.curso = curso;
        return this;
    }

    public void apply(Projeto projeto) {

        if (nomeProjeto != null) {
            projeto.alterarNomeProjeto(nomeProjeto);
        }

        if (nomeProfessor != null) {
            projeto.alterarNomeProfessor(nomeProfessor);
        }

        if (termo != null) {
            projeto.alterarTermo(termo);
        }

        if (curso != null) {
            projeto.alterarCurso(curso);
        }

        if (alunos != null)
            projeto.substituirAlunos(alunos);
    }
}