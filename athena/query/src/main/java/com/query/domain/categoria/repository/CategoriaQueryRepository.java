package com.query.domain.categoria.repository;

import com.query.domain.categoria.model.CategoriaQuery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaQueryRepository extends
        JpaRepository<CategoriaQuery, Long> {


}
