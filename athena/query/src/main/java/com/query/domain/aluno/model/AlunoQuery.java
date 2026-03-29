package com.query.domain.aluno.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import org.hibernate.annotations.Immutable;

import com.query.sk.AbstractAnemicEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Immutable
@Entity
@Table(name = "aluno")
public class AlunoQuery extends AbstractAnemicEntity<UUID> {

    @Id
    private UUID id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "matricula")
    private String matricula;

}
