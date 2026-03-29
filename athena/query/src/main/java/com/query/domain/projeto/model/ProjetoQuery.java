package com.query.domain.projeto.model;




import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

import java.util.UUID;


@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Immutable
@Entity
@Table(name = "projeto")
public class ProjetoQuery {

    @Id
    private UUID id;

    @Column(name = "nomeprojeto")
    private String nomeProjeto;

    @Column(name = "nomeprofessor")
    private String nomeProfessor;

    @Column(name = "termo")
    private int termo;

    @Column(name = "curso")
    private String curso;




}


