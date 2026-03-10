package com.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

import java.util.Map;
import java.util.UUID;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.core.domain.aluno.usecase.RegistrarAlunoUseCase;
import com.infra.UriResponseBuilder;
import com.query.domain.aluno.app.AlunoQueryAppService;
import com.query.domain.aluno.projection.Aluno;
import com.core.sk.identifiers.AlunoId;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor

@Tag(name = "UserController", description = "API para gerenciar alunos")
@RestController
@RequestMapping(path = "/api/v1/alunos", produces = APPLICATION_JSON_VALUE)
public class AlunoController {

    private final RegistrarAlunoUseCase registrarAlunoAppService;
    private final AlunoQueryAppService alunoQueryAppService;

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> registrar(@RequestBody RegistrarAlunoUseCase.RegistrarAluno cmd) {

        AlunoId id = registrarAlunoAppService.handle(cmd);

        return UriResponseBuilder.builder()
            .fullPath(fromCurrentRequest().toUriString())
            .id(id.asString())
            .build()
            .toCreated();
    }

    @GetMapping(path = "/{id}")
    public Aluno buscaPorId(@PathVariable UUID id) {
        return alunoQueryAppService.recuperarProduto(id);
    }

    @GetMapping("/")
    public String home() {
        return "Aplicação rodando";
    }

    @GetMapping("/user")
    public Map<String, Object> user(
            @AuthenticationPrincipal OAuth2User principal) {
        System.out.println(principal.getName());
        return principal.getAttributes();
    }

    @GetMapping("/me")
    public Map<String, Object> me(Authentication authentication) {

        OAuth2User user = (OAuth2User) authentication.getPrincipal();

        return user.getAttributes();
    }



}
