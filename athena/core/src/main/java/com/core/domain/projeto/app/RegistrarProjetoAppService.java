package com.core.domain.projeto.app;

import com.core.domain.projeto.model.Projeto;
import com.core.domain.projeto.repository.ProjetoDomainRepository;
import com.core.domain.projeto.usecase.RegistrarProjetoUseCase;
import com.core.sk.identifiers.ProjetoId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.google.cloud.spring.pubsub.core.PubSubTemplate;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Service
@RequiredArgsConstructor

public class RegistrarProjetoAppService implements RegistrarProjetoUseCase {

    private final ProjetoDomainRepository repository;

    private final PubSubTemplate pubSubTemplate;


    @Transactional(transactionManager = "transactionManager")
    @Override
    public ProjetoId handle(RegistrarProjetoUseCase.RegistrarProjeto command, String professor) {
        System.out.println(command);




        Projeto p = Projeto.builder()
                .nomeProjeto(command.nomeProjeto())
                .nomeProf(professor)
                .curso(command.curso())
                .termo(command.termo())
                .build();

        repository.save(p);




        // Registra a publicação para ocorrer após o commit
        if (TransactionSynchronizationManager.isSynchronizationActive()) {
            TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronization() {
                @Override
                public void afterCommit() {
                    // Publica no Pub/Sub após a transação confirmar
                    pubSubTemplate.publish("project-submitted-topic", command.nomeProjeto());
                }
            });
        } else {
            // Caso não esteja em transação, publica imediatamente
            pubSubTemplate.publish("project-submitted-topic", command.nomeProjeto());
        }





        return p.getId();
    }




}
