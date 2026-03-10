package com.core.domain.projeto.usecase;

import com.core.sk.identifiers.ProjetoId;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public interface RegistrarProjetoUseCase {

    ProjetoId handle(RegistrarProjeto command, String professor);

    record RegistrarProjeto(

            @Valid
            @NotNull(message = "Nome do projeto obrigatório")
            String nomeProjeto,

            @NotNull(message = "Nome do curso obrigatório")
            String curso,

            int termo,

            @NotNull(message = "Nome do professor obrigatório")
            String nomeProfessor




    ) {}

}
