package com.core.domain.categoria.app;



import com.core.domain.categoria.model.Categoria;
import com.core.domain.categoria.repository.CategoriaDomainRepository;
import com.core.domain.categoria.usecase.RegistrarCategoriaUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class RegistrarCategoriaAppService implements RegistrarCategoriaUseCase {

    private final CategoriaDomainRepository repository;

    @Override
    public Long handle(RegistrarCategoriaUseCase.RegistrarCategoria command) {


        Categoria categoria = repository.findById(command.id())
                .orElseGet(Categoria::nova);


        categoria.setNome(command.nome());
        return repository.save(categoria).getId();
    }




}

