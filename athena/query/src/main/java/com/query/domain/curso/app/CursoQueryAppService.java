package com.query.domain.curso.app;

import java.util.List;
import java.util.UUID;

import com.query.domain.curso.model.CursoQuery;
import com.query.domain.curso.projection.Curso;
import com.query.domain.curso.repository.CursoQueryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.query.domain.aluno.projection.Aluno;
import com.query.domain.aluno.repository.AlunoQueryRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

@Service
@Transactional(readOnly = true)
public class CursoQueryAppService {

    private final CursoQueryRepository repository;

    // o getQuery do repository quando chamado sem parâmetro retornar todos
    public List<Curso> findAll() {
        return repository.getQuery();
    }

}
