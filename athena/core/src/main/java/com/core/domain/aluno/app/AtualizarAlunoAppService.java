package com.core.domain.aluno.app;

import com.core.domain.aluno.model.Aluno;
import com.core.domain.aluno.model.AlunoBuilderUpdate;
import com.core.domain.aluno.repository.AlunoDomainRepository;
import com.core.domain.aluno.usecase.AtualizarAlunoUseCase;
import com.core.domain.aluno.usecase.RegistrarAlunoUseCase;
import com.core.domain.projeto.model.Projeto;
import com.core.domain.projeto.model.ProjetoBuilderUpdate;
import com.core.sk.identifiers.AlunoId;
import com.core.sk.identifiers.ProjetoId;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@RequiredArgsConstructor
@Service
@Transactional
public class AtualizarAlunoAppService implements AtualizarAlunoUseCase {

    private final AlunoDomainRepository repository;

    @Override
    @Transactional(transactionManager = "transactionManager")
    public void handle(UUID id, AtualizarAlunoUseCase.AtualizarAluno command) {





        Aluno aluno = repository.findById(AlunoId.from(id)).orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        AlunoBuilderUpdate builder = new AlunoBuilderUpdate()
                .nome(command.nome())
                .matricula(command.matricula());


        aluno.apply(builder);

        repository.save(aluno);


    }







}
