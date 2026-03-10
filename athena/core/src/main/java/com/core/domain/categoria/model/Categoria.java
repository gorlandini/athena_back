package com.core.domain.categoria.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import static java.util.Objects.requireNonNull;
import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED, force = true)

@DynamicUpdate
@Entity
@Table(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;



    Categoria(CategoriaBuilder builder) {

        this.nome = requireNonNull(builder.nome);

    }

    public static Categoria nova() {
        return new Categoria();
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static CategoriaBuilder builder() {
        return new CategoriaBuilder();
    }

}
