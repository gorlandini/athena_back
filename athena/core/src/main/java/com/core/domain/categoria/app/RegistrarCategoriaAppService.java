package com.core.domain.categoria.app;



import com.core.domain.categoria.model.Categoria;
import com.core.domain.categoria.repository.CategoriaDomainRepository;
import com.core.domain.categoria.usecase.RegistrarCategoriaUseCase;
import com.core.sk.identifiers.CategoriaId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class RegistrarCategoriaAppService implements RegistrarCategoriaUseCase {

    private final CategoriaDomainRepository repository;

    @Override
    public CategoriaId handle(RegistrarCategoriaUseCase.RegistrarCategoria command) {
        System.out.println(command);




        Categoria p = Categoria.builder()
                .nome(command.nome())

                .build();

        repository.save(p);

        return p.getId();
    }




}

