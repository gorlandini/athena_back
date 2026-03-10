package com.query.domain.categoria.app;

import com.query.domain.aluno.projection.Aluno;
import com.query.domain.categoria.model.CategoriaQuery;
import com.query.domain.categoria.projection.Categoria;
import com.query.domain.categoria.repository.CategoriaQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor

@Service
@Transactional(readOnly = true)
public class CategoriaQueryAppService {

    private final CategoriaQueryRepository repository;





    // o getQuery do repository quando chamado sem parâmetro retornar todos
    public List<CategoriaQuery> findAll() {
        return repository.findAll();
    }


    public CategoriaQuery recuperarCategoria(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));


    }

}
