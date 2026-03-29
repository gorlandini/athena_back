package com.core.domain.projeto.app;

import com.core.domain.categoria.model.Categoria;
import com.core.domain.categoria.usecase.ExcluirCategoriaUseCase;
import com.core.domain.projeto.model.Projeto;
import com.core.domain.projeto.repository.ProjetoDomainRepository;
import com.core.domain.projeto.usecase.ExcluirProjetoUseCase;
import com.core.sk.identifiers.ProjetoId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExcluirProjetoAppService implements ExcluirProjetoUseCase {

    private final ProjetoDomainRepository repository;

    @Override
    public void excluir(ExcluirProjeto command) {

        ProjetoId id = ProjetoId.from(command.id());

        Projeto projeto = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado"));

        repository.delete(projeto);
    }


}
