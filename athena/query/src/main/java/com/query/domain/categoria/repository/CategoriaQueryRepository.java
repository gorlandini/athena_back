package com.query.domain.categoria.repository;

import com.query.domain.categoria.model.CategoriaQuery;
import com.query.domain.categoria.projection.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CategoriaQueryRepository extends
        JpaRepository<CategoriaQuery, Long> {


}
