package com.core.domain.aluno.model;

import static java.util.Objects.requireNonNull;
import static lombok.AccessLevel.*;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.core.sk.identifiers.AlunoId;

import lombok.Getter;
import lombok.NoArgsConstructor;


@SuppressWarnings("squid:S2160")

@Getter
@NoArgsConstructor(access = PROTECTED, force = true)

@DynamicUpdate
@Entity
@Table(name = "aluno")
public class Aluno {

    @EmbeddedId
    @AttributeOverride(name = AlunoId.ATTR, column = @Column(name = "id"))
    private AlunoId id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "matricula")
    private String matricula;

    Aluno(AlunoBuilder builder) {
        System.out.println("CHEGOU NA ENTITY");
        requireNonNull(builder, "builder não pode ser nulo");

        this.id = builder.id;
        this.nome = builder.nome;
        this.matricula = builder.matricula;
    }

    public static AlunoBuilder builder() {
        return new AlunoBuilder();
    }

    public void alterarNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("nome inválido");
        }


        this.nome = requireNonNull(nome);
    }

    public void alterarMatricula(String matricula) {
        this.matricula = requireNonNull(matricula);
    }

    public void apply(AlunoBuilderUpdate builder) {
        requireNonNull(builder);

        if (builder.nome != null) {
            alterarNome(builder.nome);
        }

        if (builder.matricula != null) {
            alterarMatricula(builder.matricula);
        }
    }



}

