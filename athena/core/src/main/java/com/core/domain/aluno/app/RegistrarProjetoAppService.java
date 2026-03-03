package com.core.domain.aluno.app;

import com.core.domain.aluno.model.Aluno;
import com.core.domain.aluno.model.Projeto;
import com.core.domain.aluno.repository.AlunoDomainRepository;
import com.core.domain.aluno.repository.ProjetoDomainRepository;
import com.core.domain.aluno.usecase.RegistrarAlunoUseCase;
import com.core.domain.aluno.usecase.RegistrarProjetoUseCase;
import com.core.sk.identifiers.AlunoId;
import com.core.sk.identifiers.ProjetoId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class RegistrarProjetoAppService implements RegistrarProjetoUseCase {

    private final ProjetoDomainRepository repository;

    @Override
    public ProjetoId handle(RegistrarProjetoUseCase.RegistrarProjeto command, String professor) {
        System.out.println(command);




        Projeto p = Projeto.builder()
                .nomeProjeto(command.nomeProjeto())
                .nomeProf(professor)
                .build();

        repository.save(p);

        return p.getId();
    }




}
