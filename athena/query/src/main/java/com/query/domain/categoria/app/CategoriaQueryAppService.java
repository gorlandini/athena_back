package com.query.domain.categoria.app;

import com.query.domain.aluno.projection.Aluno;
import com.query.domain.categoria.projection.Categoria;
import com.query.domain.categoria.repository.CategoriaQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor

@Service
@Transactional(readOnly = true)
public class CategoriaQueryAppService {

    private final CategoriaQueryRepository repository;

    // o getQuery do repository quando chamado sem parâmetro retornar todos
    public List<Categoria> findAll() {
        return repository.getQuery();
    }
    public Categoria recuperarCategoria(UUID id) {
        return repository.get(id);
    }

}
