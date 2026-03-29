package com.core.domain.projeto.model;

public class ProjetoCriadoEvent {

    private final String nomeProjeto;
    private final String professor;

    public ProjetoCriadoEvent(String nomeProjeto, String professor) {
        this.nomeProjeto = nomeProjeto;
        this.professor = professor;
    }

    public String getNomeProjeto() {
        return nomeProjeto;
    }

    public String getProfessor() {
        return professor;
    }
}
