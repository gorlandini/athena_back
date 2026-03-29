package com.query.domain.projeto.repository;

import com.query.domain.projeto.model.ProjetoQuery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProjetoQueryRepository extends
        JpaRepository<ProjetoQuery, UUID> {


}
