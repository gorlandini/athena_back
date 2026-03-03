package com.query.domain.aluno.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.Repository;

import com.query.domain.aluno.model.AlunoQuery;
import com.query.domain.aluno.projection.Aluno;

public interface AlunoQueryRepository extends
    Repository<AlunoQuery, UUID> {

    Optional<Aluno> findProjectedById(UUID id);
    Optional<AlunoQuery> findById(UUID id);


    default Aluno get(UUID id) {
        return findProjectedById(id)
            .orElseThrow(RuntimeException::new);
    }

    default AlunoQuery getQuery(UUID id) {
        return findById(id)
            .orElseThrow(RuntimeException::new);
    }

}
