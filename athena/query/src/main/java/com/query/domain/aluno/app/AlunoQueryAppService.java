package com.query.domain.aluno.app;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.query.domain.aluno.projection.Aluno;
import com.query.domain.aluno.repository.AlunoQueryRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

@Service
@Transactional(readOnly = true)
public class AlunoQueryAppService {

    private final AlunoQueryRepository repository;

    public Aluno recuperarProduto(UUID id) {
        return repository.get(id);
    }

}
