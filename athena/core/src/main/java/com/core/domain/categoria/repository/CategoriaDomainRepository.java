package com.core.domain.categoria.repository;

import com.core.domain.categoria.model.Categoria;
import com.core.sk.identifiers.CategoriaId;
import org.springframework.data.repository.Repository;

public interface CategoriaDomainRepository extends Repository<Categoria, CategoriaId> {
     public void save(Categoria categoria);

}
