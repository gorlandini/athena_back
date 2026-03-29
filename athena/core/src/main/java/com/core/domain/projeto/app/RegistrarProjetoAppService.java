package com.core.domain.projeto.app;

import com.core.domain.projeto.model.Projeto;
import com.core.domain.projeto.model.ProjetoCriadoEvent;
import com.core.domain.projeto.repository.ProjetoDomainRepository;
import com.core.domain.projeto.usecase.RegistrarProjetoUseCase;
import com.core.sk.identifiers.ProjetoId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.google.cloud.spring.pubsub.core.PubSubTemplate;
import org.springframework.context.ApplicationEventPublisher;

@Service
@RequiredArgsConstructor

public class RegistrarProjetoAppService implements RegistrarProjetoUseCase {

    private final ProjetoDomainRepository repository;

    private final PubSubTemplate pubSubTemplate;
    private final ApplicationEventPublisher eventPublisher;


    @Transactional(transactionManager = "transactionManager")
    @Override
    public ProjetoId handle(RegistrarProjetoUseCase.RegistrarProjeto command) {
        System.out.println(command);




        Projeto p = Projeto.builder()
                .nomeProjeto(command.nomeProjeto())
                .nomeProfessor(command.nomeProfessor())
                .nomeCurso(command.curso())
                .termo(command.termo())

                .build();


        p.atualizarAlunos(command.alunos());
        repository.save(p);




        eventPublisher.publishEvent(
                new ProjetoCriadoEvent(command.nomeProjeto(), command.nomeProfessor())
        );


        // Registra a publicação para ocorrer após o commit
   /*     if (TransactionSynchronizationManager.isSynchronizationActive()) {
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
        } */





        return p.getId();
    }




}
