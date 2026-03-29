package com.core.domain.aluno.usecase;

import com.core.sk.identifiers.AlunoId;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public interface AtualizarAlunoUseCase {

    void handle(UUID id, AtualizarAluno command);

    record AtualizarAluno(

            AlunoId id,

            @Valid
            @NotNull(message = "Matricula obrigatoria")
            String matricula,

            @Valid
            @NotNull(message = "Nome obrigatorio")
            String nome

    ) {}

}
