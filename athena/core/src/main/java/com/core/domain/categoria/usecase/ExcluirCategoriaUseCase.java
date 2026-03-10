package com.core.domain.categoria.usecase;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public interface ExcluirCategoriaUseCase {

    void excluir(ExcluirCategoriaUseCase.ExcluirCategoria command);



    record ExcluirCategoria(



            @Valid
            @NotNull(message = "É necessário informar o id da categoria")
            Long id

    ) {}
}
