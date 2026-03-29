package com.core.domain.categoria.repository;

import com.core.domain.categoria.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaDomainRepository extends JpaRepository<Categoria, Long> {


}
