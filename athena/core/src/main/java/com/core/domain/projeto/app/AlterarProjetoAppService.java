package com.core.domain.projeto.app;

import com.core.domain.projeto.model.Projeto;
import com.core.domain.projeto.model.ProjetoBuilderUpdate;
import com.core.domain.projeto.repository.ProjetoDomainRepository;
import com.core.domain.projeto.usecase.AtualizarProjetoUseCase;
import com.core.sk.identifiers.ProjetoId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AlterarProjetoAppService implements AtualizarProjetoUseCase {

    private final ProjetoDomainRepository repository;

    @Override
    @Transactional(transactionManager = "transactionManager")
    public void handle(UUID id, AtualizarProjetoUseCase.AtualizarProjeto command) {

        Projeto projeto = repository.findById(ProjetoId.from(id))
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado"));

        ProjetoBuilderUpdate builder = new ProjetoBuilderUpdate()
                .nomeProjeto(command.nomeProjeto())
                .curso(command.curso())
                .termo(command.termo())
                .nomeProfessor(command.nomeProfessor())
                .alunos(command.alunos());

        projeto.apply(builder);

        repository.save(projeto);
    }

}
