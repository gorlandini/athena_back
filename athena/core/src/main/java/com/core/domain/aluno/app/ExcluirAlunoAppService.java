package com.core.domain.aluno.app;

import com.core.domain.aluno.model.Aluno;
import com.core.domain.aluno.repository.AlunoDomainRepository;
import com.core.domain.aluno.usecase.ExcluirAlunoUseCase;
import com.core.domain.projeto.model.Projeto;
import com.core.domain.projeto.repository.ProjetoDomainRepository;
import com.core.domain.projeto.usecase.ExcluirProjetoUseCase;
import com.core.sk.identifiers.AlunoId;
import com.core.sk.identifiers.ProjetoId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExcluirAlunoAppService implements ExcluirAlunoUseCase {

    private final AlunoDomainRepository repository;

    @Override
    public void excluir(ExcluirAluno command) {

        AlunoId id = AlunoId.from(command.id());

        Aluno aluno = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        repository.delete(aluno);
    }


}
