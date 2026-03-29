package com.core.domain.projeto.repository;

import com.core.domain.projeto.model.Projeto;
import com.core.sk.identifiers.ProjetoId;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface ProjetoDomainRepository extends Repository<Projeto, ProjetoId> {

    void save(Projeto projeto);
    void delete(Projeto projeto);
    Optional<Projeto> findById(ProjetoId id);

}
