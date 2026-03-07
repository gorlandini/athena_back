package com.core.domain.projeto.model;



import static java.util.Objects.requireNonNull;
import static lombok.AccessLevel.PROTECTED;

import com.core.sk.identifiers.ProjetoId;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import lombok.Getter;
import lombok.NoArgsConstructor;


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
        this.id = builder.id;
        this.nomeProfessor = requireNonNull(builder.nomeProfessor);
        this.nomeProjeto = requireNonNull(builder.nomeProjeto);
        this.termo = requireNonNull(builder.termo);
        this.curso = requireNonNull(builder.curso);
    }

    public static ProjetoBuilder builder() {
        return new ProjetoBuilder();
    }

}


