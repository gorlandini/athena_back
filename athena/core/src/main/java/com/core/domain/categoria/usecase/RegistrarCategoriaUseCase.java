package com.core.domain.categoria.usecase;

import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public interface RegistrarCategoriaUseCase {

    Long handle(RegistrarCategoria command);



    record RegistrarCategoria(

            @Id
            Long id,

            @Valid
            @NotBlank(message = "Nome da categoria não pode ser vazio")
            @NotNull(message = "Nome da categoria obrigatorio")
            String nome

    ) {}

}