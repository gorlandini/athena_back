package com.core.domain.aluno.app;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.core.domain.aluno.model.Aluno;
import com.core.domain.aluno.repository.AlunoDomainRepository;
import com.core.domain.aluno.usecase.RegistrarAlunoUseCase;
import com.core.sk.identifiers.AlunoId;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional
public class RegistrarAlunoAppService implements RegistrarAlunoUseCase {

    private final AlunoDomainRepository repository;

    @Override
    public AlunoId handle(RegistrarAluno command) {

        Aluno produto = Aluno.builder()
            .nome(command.nome())
            .matricula(command.matricula())
            .build();

        repository.save(produto);

        return produto.getId();
    }

}
