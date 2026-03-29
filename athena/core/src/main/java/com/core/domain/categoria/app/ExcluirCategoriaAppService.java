package com.core.domain.categoria.app;



import com.core.domain.categoria.model.Categoria;
import com.core.domain.categoria.repository.CategoriaDomainRepository;
import com.core.domain.categoria.usecase.ExcluirCategoriaUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ExcluirCategoriaAppService implements ExcluirCategoriaUseCase {

    private final CategoriaDomainRepository repository;

    @Override
    public void excluir(ExcluirCategoriaUseCase.ExcluirCategoria command) {

        Categoria c = repository.findById(command.id())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        repository.delete(c);


    }




}

