package com.controller;



import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

import java.util.UUID;

import com.core.domain.categoria.usecase.ExcluirCategoriaUseCase;
import com.core.domain.categoria.usecase.RegistrarCategoriaUseCase;
import com.query.domain.categoria.app.CategoriaQueryAppService;
import com.query.domain.categoria.model.CategoriaQuery;
import com.query.domain.categoria.projection.Categoria;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.infra.UriResponseBuilder;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor

@RestController
@RequestMapping(path = "/api/v1/categoria", produces = APPLICATION_JSON_VALUE)
@Tag(name = "CategoriaController", description = "API para gerenciar categorias")
public class CategoriaController {

    private final RegistrarCategoriaUseCase registrarCategoriaAppService;
    private final CategoriaQueryAppService categoriaQueryAppService;
    private final ExcluirCategoriaUseCase excluirCategoriaAppService;

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> registrar(@RequestBody RegistrarCategoriaUseCase.RegistrarCategoria cmd) {

        Long id = registrarCategoriaAppService.handle(cmd);

        return UriResponseBuilder.builder()
                .fullPath(fromCurrentRequest().toUriString())
                .id(String.valueOf(id))
                .build()
                .toCreated();
    }

    @GetMapping(path = "/{id}")
    public CategoriaQuery buscaPorId(@PathVariable Long id) {
        return categoriaQueryAppService.recuperarCategoria(id);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        ExcluirCategoriaUseCase.ExcluirCategoria command =
                new ExcluirCategoriaUseCase.ExcluirCategoria(id);

        excluirCategoriaAppService.excluir(command);
        return ResponseEntity.noContent().build();
    }





}
