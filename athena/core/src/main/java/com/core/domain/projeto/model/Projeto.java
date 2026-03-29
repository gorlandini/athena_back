package com.core.domain.projeto.model;



import static java.util.Objects.requireNonNull;
import static lombok.AccessLevel.PROTECTED;


import com.core.domain.participacao_projeto.ParticipacaoProjeto;
import com.core.sk.identifiers.AlunoId;
import com.core.sk.identifiers.ProjetoId;
import jakarta.persistence.*;

import org.hibernate.annotations.DynamicUpdate;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@SuppressWarnings("squid:S2160")

@Getter
@NoArgsConstructor(access = PROTECTED, force = true)

@DynamicUpdate
@Entity
@Table(name = "projeto")
public class Projeto {

    @EmbeddedId
    @AttributeOverride(name = ProjetoId.ATTR, column = @Column(name = "id"))
    private ProjetoId id;

    @Column(name = "nomeprojeto")
    private String nomeProjeto;

    @Column(name = "nomeprofessor")
    private String nomeProfessor;

    @Column(name = "termo")
    private int termo;

    @Column(name = "curso")
    private String curso;

    Projeto(ProjetoBuilder builder) {
        this.id = new ProjetoId(UUID.randomUUID().toString());
        this.nomeProfessor = requireNonNull(builder.nomeProfessor);
        this.nomeProjeto = requireNonNull(builder.nomeProjeto);
        this.termo = requireNonNull(builder.termo);
        this.curso = requireNonNull(builder.curso);
    }

    public static ProjetoBuilder builder() {
        return new ProjetoBuilder();
    }


    public void alterarNomeProjeto(String nomeProjeto) {
        this.nomeProjeto = requireNonNull(nomeProjeto);
    }

    public void alterarNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = requireNonNull(nomeProfessor);
    }

    public void alterarTermo(int termo) {
        this.termo = termo;
    }

    public void alterarCurso(String curso) {
        this.curso = requireNonNull(curso);
    }

    // 🔥 método central de update
    public void apply(ProjetoBuilderUpdate builder) {
        requireNonNull(builder);

        alterarDados(

                builder.nomeProjeto,
                builder.nomeProfessor,
                builder.curso,
                builder.termo
        );

        atualizarAlunos(builder.alunos);
    }

    @OneToMany(mappedBy = "projeto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ParticipacaoProjeto> alunos = new ArrayList<>();

    public void alterarDados(String nomeProjeto, String nomeProfessor, String curso, int termo) {
        this.nomeProjeto = requireNonNull(nomeProjeto);
        this.nomeProfessor = requireNonNull(nomeProfessor);
        this.curso = requireNonNull(curso);
        this.termo = termo;
    }



    public void atualizarAlunos(List<AlunoId> novosAlunos) {
        this.alunos.clear(); // orphanRemoval → DELETE automático

        if (novosAlunos != null) {
            novosAlunos.forEach(this::adicionarAluno);
        }
    }


    public void adicionarAluno(AlunoId aluno) {
        requireNonNull(aluno);

        boolean jaExiste = this.alunos.stream()
                .anyMatch(a -> a.getAlunoId().equals(aluno));

        if (jaExiste) {
            throw new RuntimeException("Aluno já está no projeto");
        }

        this.alunos.add(new ParticipacaoProjeto(aluno, this));
    }


    public void removerAluno(AlunoId alunoId) {
        requireNonNull(alunoId);

        this.alunos.removeIf(a -> a.getAlunoId().equals(alunoId));
    }


    public void substituirAlunos(List<AlunoId> alunos) {
        this.alunos.clear();
        alunos.stream().forEach(a -> alunos.add(a));
    }
}


