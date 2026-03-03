package com.core.domain.aluno.usecase;

import com.core.sk.identifiers.AlunoId;
import com.core.sk.identifiers.ProjetoId;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public interface RegistrarProjetoUseCase {

    ProjetoId handle(RegistrarProjeto command, String professor);

    record RegistrarProjeto(

            @Valid
            @NotNull(message = "Nome do projeto obrigatório")
            String nomeProjeto



    ) {}

}
