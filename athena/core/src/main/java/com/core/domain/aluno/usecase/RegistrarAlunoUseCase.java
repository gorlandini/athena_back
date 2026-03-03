package com.core.domain.aluno.usecase;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import com.core.sk.identifiers.AlunoId;

public interface RegistrarAlunoUseCase {

    AlunoId handle(RegistrarAluno command);

    record RegistrarAluno(

        @Valid
        @NotNull(message = "Matricula obrigatoria")
        String matricula,

        @Valid
        @NotNull(message = "Nome obrigatorio")
        String nome

    ) {}

}
