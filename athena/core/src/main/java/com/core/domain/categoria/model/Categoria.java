package com.core.domain.categoria.model;

import com.core.sk.identifiers.CategoriaId;
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

    @EmbeddedId
    @AttributeOverride(name = CategoriaId.ATTR, column = @Column(name = "id"))
    private CategoriaId id;

    @Column(name = "nome")
    private String nome;



    Categoria(CategoriaBuilder builder) {
        this.id = builder.id;
        this.nome = requireNonNull(builder.nome);

    }

    public static CategoriaBuilder builder() {
        return new CategoriaBuilder();
    }

}
