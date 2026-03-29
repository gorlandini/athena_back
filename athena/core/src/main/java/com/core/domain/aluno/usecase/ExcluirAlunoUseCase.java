package com.core.domain.aluno.usecase;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public interface ExcluirAlunoUseCase {

    void excluir(ExcluirAluno command);



    record ExcluirAluno(



            @Valid
            @NotNull(message = "É necessário informar o id do aluno")
            UUID id

    ) {}
}
