package com.query.domain.curso.repository;

import java.util.List;
import java.util.Optional;

import com.query.domain.curso.projection.Curso;
import com.query.domain.curso.model.CursoQuery;
import org.springframework.data.repository.Repository;

public interface CursoQueryRepository extends
        Repository<CursoQuery, Long> {

    Optional<Curso> findProjectedById(Long id);
    Optional<CursoQuery> findById(Long id);
    List<Curso> findProjectedBy();


    default Curso get(Long id) {
        return findProjectedById(id)
                .orElseThrow(RuntimeException::new);
    }

    default CursoQuery getQuery(Long id) {
        return findById(id)
                .orElseThrow(RuntimeException::new);
    }

    default List<Curso> getQuery() {
        return findProjectedBy();
    }

}
