package com.query.domain.projeto.app;

import com.query.domain.categoria.model.CategoriaQuery;
import com.query.domain.projeto.model.ProjetoQuery;
import com.query.domain.projeto.repository.ProjetoQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor

@Service
@Transactional(readOnly = true)
public class ProjetoQueryAppService {

    private final ProjetoQueryRepository repository;





    // o getQuery do repository quando chamado sem parâmetro retornar todos
    public List<ProjetoQuery> findAll() {
        return repository.findAll();
    }


    public ProjetoQuery recuperarCategoria(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado"));


    }

}
