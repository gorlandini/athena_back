package com.query.domain.categoria.model;


import com.query.sk.AbstractAnemicEntity;
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
@Table(name = "categoria")
public class CategoriaQuery extends AbstractAnemicEntity<UUID> {

    @Id
    private UUID id;

    @Column(name = "nome")
    private String nome;



}

