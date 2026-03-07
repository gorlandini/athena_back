package com.core.domain.categoria.usecase;

import com.core.sk.identifiers.CategoriaId;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public interface RegistrarCategoriaUseCase {

    CategoriaId handle(RegistrarCategoria command);

    record RegistrarCategoria(



            @Valid
            @NotNull(message = "Nome da categoria obrigatorio")
            String nome

    ) {}

}