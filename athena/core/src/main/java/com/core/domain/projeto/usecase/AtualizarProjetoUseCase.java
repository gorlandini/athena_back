package com.core.domain.projeto.usecase;



import java.util.List;
import java.util.UUID;

import com.core.sk.identifiers.AlunoId;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public interface AtualizarProjetoUseCase {

    void handle(UUID id, AtualizarProjeto command);

    record AtualizarProjeto(

            String nomeProjeto,
            String curso,
            Integer termo,
            String nomeProfessor,
            List<AlunoId> alunos

    ) {}
}
