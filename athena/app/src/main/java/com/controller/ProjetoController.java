package com.controller;

import com.core.domain.projeto.usecase.RegistrarProjetoUseCase;
import com.core.sk.identifiers.ProjetoId;
import com.infra.UriResponseBuilder;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/projetos", produces = APPLICATION_JSON_VALUE)
public class ProjetoController {

    private final RegistrarProjetoUseCase registrarProjetoAppService;
    //private final ProjetoQueryAppService alunoQueryAppService;

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> registrar(@RequestBody RegistrarProjetoUseCase.RegistrarProjeto cmd, Authentication authentication) {


        OAuth2User user = (OAuth2User) authentication.getPrincipal();

        Map<String, Object> attrs = user.getAttributes();


        String professor = (String) user.getAttributes().get("name");

        ProjetoId id = registrarProjetoAppService.handle(cmd, professor);




        return UriResponseBuilder.builder()
                .fullPath(fromCurrentRequest().toUriString())
                .id(id.asString())
                .build()
                .toCreated();
    }








}
