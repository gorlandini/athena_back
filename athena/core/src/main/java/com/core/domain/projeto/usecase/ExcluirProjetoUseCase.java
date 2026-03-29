package com.core.domain.projeto.usecase;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public interface ExcluirProjetoUseCase {

    void excluir(com.core.domain.projeto.usecase.ExcluirProjetoUseCase.ExcluirProjeto command);



    record ExcluirProjeto(



            @Valid
            @NotNull(message = "É necessário informar o id do projeto")
            UUID id

    ) {}
}
