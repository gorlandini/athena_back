import com.core.domain.aluno.app.RegistrarAlunoAppService;
import com.core.domain.aluno.model.Aluno;
import com.core.domain.aluno.repository.AlunoDomainRepository;
import com.core.domain.aluno.usecase.RegistrarAlunoUseCase;
import com.core.sk.identifiers.AlunoId;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@ExtendWith(MockitoExtension.class)
class RegistrarAlunoAppServiceTest {

    @Mock
    private AlunoDomainRepository repository;

    @InjectMocks
    private RegistrarAlunoAppService service;

    @Test
    void deveRegistrarAlunoComSucesso() {

        // given
        RegistrarAlunoUseCase.RegistrarAluno command = new RegistrarAlunoUseCase.RegistrarAluno("Guilherme", "123");

        // quando o save for chamado, simulamos retorno do próprio aluno
        doAnswer(invocation -> {
            Aluno aluno = invocation.getArgument(0);
            // simula geração de ID (caso seu domain não faça isso automaticamente)
            return aluno;
        }).when(repository).save(any(Aluno.class));

        // when
        AlunoId id = service.handle(command);

        // then
        assertNotNull(id);
        verify(repository, times(1)).save(any(Aluno.class));
    }




    @Test
    void deveLancarErroQuandoNomeVazio() {

        RegistrarAlunoUseCase.RegistrarAluno command =
                new RegistrarAlunoUseCase.RegistrarAluno("123", "");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            service.handle(command);
        });

        assertTrue(exception.getMessage().contains("nome"));
    }








}
