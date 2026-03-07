package com.core.domain.projeto.app;

import com.core.domain.projeto.model.Projeto;
import com.core.domain.projeto.repository.ProjetoDomainRepository;
import com.core.domain.projeto.usecase.RegistrarProjetoUseCase;
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
