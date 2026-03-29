package com.controller;

import com.controller.response.ApiResponse;
import com.core.domain.categoria.usecase.ExcluirCategoriaUseCase;
import com.core.domain.projeto.usecase.AtualizarProjetoUseCase;
import com.core.domain.projeto.usecase.ExcluirProjetoUseCase;
import com.core.domain.projeto.usecase.RegistrarProjetoUseCase;
import com.core.sk.identifiers.ProjetoId;
import com.infra.UriResponseBuilder;
import com.query.domain.projeto.app.ProjetoQueryAppService;
import com.query.domain.projeto.model.ProjetoQuery;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;
@Tag(name = "ProjetoController", description = "API para gerenciar projetos")
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/projetos", produces = APPLICATION_JSON_VALUE)
public class ProjetoController {

    private final RegistrarProjetoUseCase registrarProjetoAppService;
    private final ExcluirProjetoUseCase excluirProjetoAppService;
    private final AtualizarProjetoUseCase atualizarProjetoAppService;
    private final ProjetoQueryAppService projetoQueryAppService;

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> registrar(@RequestBody RegistrarProjetoUseCase.RegistrarProjeto cmd, Authentication authentication) {


      //  OAuth2User user = (OAuth2User) authentication.getPrincipal();

     //   Map<String, Object> attrs = user.getAttributes();


      //  String professor = (String) user.getAttributes().get("name");
        String professor = "Teste";

        ProjetoId id = registrarProjetoAppService.handle(cmd);




        return UriResponseBuilder.builder()
                .fullPath(fromCurrentRequest().toUriString())
                .id(id.asString())
                .build()
                .toCreated();
    }


    @GetMapping
    public ResponseEntity<ApiResponse<List<ProjetoQuery>>> listAll() {

        var projetos = projetoQueryAppService.findAll();


        return ResponseEntity.ok(
                ApiResponse.success(projetos)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable @Valid UUID id) {
        ExcluirProjetoUseCase.ExcluirProjeto command =
                new ExcluirProjetoUseCase.ExcluirProjeto(id);


        excluirProjetoAppService.excluir(command);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public void atualizar(
            @PathVariable UUID id,
            @RequestBody AtualizarProjetoUseCase.AtualizarProjeto command
    ) {
        atualizarProjetoAppService.handle(id, command);
    }








}
