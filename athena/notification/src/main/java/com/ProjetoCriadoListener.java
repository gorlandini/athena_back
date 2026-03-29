package com;

import com.core.domain.projeto.model.ProjetoCriadoEvent;
import com.google.cloud.spring.pubsub.core.PubSubTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component

public class ProjetoCriadoListener {



    private static final Logger log = LoggerFactory.getLogger(ProjetoCriadoListener.class);


    private final PubSubTemplate pubSubTemplate;

    public ProjetoCriadoListener(PubSubTemplate pubSubTemplate) {
        System.out.println("Listener carregado!");
        this.pubSubTemplate = pubSubTemplate;
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void handle(ProjetoCriadoEvent event) {

        System.out.println("Evento recebido: " + event.getNomeProjeto());
        log.info("Evento recebido: {}", event.getNomeProjeto());
        pubSubTemplate.publish(
                "project-submitted-topic",
                event.getNomeProjeto()
        );
    }
}
