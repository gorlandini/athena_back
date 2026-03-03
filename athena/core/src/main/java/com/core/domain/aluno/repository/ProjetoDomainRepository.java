package com.core.domain.aluno.repository;

import com.core.domain.aluno.model.Aluno;
import com.core.domain.aluno.model.Projeto;
import com.core.sk.identifiers.ProjetoId;
import org.springframework.data.repository.Repository;

public interface ProjetoDomainRepository extends Repository<Projeto, ProjetoId> {

    void save(Projeto projeto);

}
