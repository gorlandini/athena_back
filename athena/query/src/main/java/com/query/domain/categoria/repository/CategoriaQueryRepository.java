package com.query.domain.categoria.repository;

import com.query.domain.categoria.model.CategoriaQuery;
import com.query.domain.categoria.projection.Categoria;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CategoriaQueryRepository extends
        Repository<CategoriaQuery, UUID> {

    Optional<Categoria> findProjectedById(UUID id);
    Optional<CategoriaQuery> findById(UUID id);
    List<Categoria> findProjectedBy();


    default Categoria get(UUID id) {
        return findProjectedById(id)
                .orElseThrow(RuntimeException::new);
    }

    default CategoriaQuery getQuery(UUID id) {
        return findById(id)
                .orElseThrow(RuntimeException::new);
    }

    default List<Categoria> getQuery() {
        return findProjectedBy();
    }

}
