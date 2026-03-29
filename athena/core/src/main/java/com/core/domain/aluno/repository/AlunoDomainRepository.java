package com.core.domain.aluno.repository;

import org.springframework.data.repository.Repository;

import com.core.domain.aluno.model.Aluno;
import com.core.sk.identifiers.AlunoId;

import java.util.Optional;

public interface AlunoDomainRepository extends Repository<Aluno, AlunoId> {

    void save(Aluno aluno);
    void delete(Aluno aluno);
    Optional<Aluno> findById(AlunoId id);


}