package com.core.domain.projeto.usecase;

import com.core.sk.identifiers.AlunoId;
import com.core.sk.identifiers.ProjetoId;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.UUID;

public interface RegistrarProjetoUseCase {

    ProjetoId handle(RegistrarProjeto command);

    record RegistrarProjeto(

            @Valid
            @NotNull(message = "Nome do projeto obrigatório")
            String nomeProjeto,

            @NotNull(message = "Nome do curso obrigatório")
            String curso,

            int termo,

            @NotNull(message = "Nome do professor obrigatório")
            String nomeProfessor,

            List<AlunoId> alunos


    ) {}

}
