package com.core.domain.projeto.model;

import com.core.domain.aluno.model.Aluno;
import com.core.domain.participacao_projeto.ParticipacaoProjeto;
import com.core.sk.identifiers.AlunoId;
import com.core.sk.identifiers.ProjetoId;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.core.domain.participacao_projeto.ParticipacaoProjeto;
import com.core.sk.identifiers.AlunoId;
import com.core.sk.identifiers.ProjetoId;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProjetoBuilder {

    protected ProjetoId id;
    protected String nomeProjeto;
    protected String nomeProfessor;
    protected int termo;
    protected String curso;
    protected List<ParticipacaoProjeto> alunos = new ArrayList<>();

    // outros campos do projeto podem ser adicionados aqui

    public ProjetoBuilder() {
        // gerar um ID temporário se necessário
        this.id = ProjetoId.from(UUID.randomUUID());
    }

    public ProjetoBuilder id(ProjetoId id) {
        this.id = id;
        return this;
    }

    public ProjetoBuilder nomeProjeto(String nome) {
        this.nomeProjeto = nome;
        return this;
    }

    public ProjetoBuilder nomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
        return this;
    }

    public ProjetoBuilder termo(int termo) {
        this.termo = termo;
        return this;
    }

    public ProjetoBuilder nomeCurso(String curso) {
        this.curso = curso;
        return this;
    }

    /*public ProjetoBuilder alunos(List<AlunoId> alunosIds) {
        if (alunosIds != null) {
            alunosIds.forEach(alunoId ->
                    this.alunos.add(new ParticipacaoProjeto(this.id, alunoId))
            );
        }
        return this;
    }*/

    public Projeto build() {
        this.id = ProjetoId.generate();
        return new Projeto(this);
    }
    /*
    public Projeto build() {
        Projeto projeto = new Projeto(this.id, this.nome);
        alunos.forEach(projeto::adicionarParticipacao); // adiciona participações corretamente
        return projeto;
    } */
}