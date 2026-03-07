package com.controller;



import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

import java.util.UUID;

import com.core.domain.categoria.usecase.RegistrarCategoriaUseCase;
import com.core.sk.identifiers.CategoriaId;
import com.query.domain.categoria.app.CategoriaQueryAppService;
import com.query.domain.categoria.projection.Categoria;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infra.UriResponseBuilder;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor

@RestController
@RequestMapping(path = "/api/v1/categoria", produces = APPLICATION_JSON_VALUE)
public class CategoriaController {

    private final RegistrarCategoriaUseCase registrarCategoriaAppService;
    private final CategoriaQueryAppService categoriaQueryAppService;

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> registrar(@RequestBody RegistrarCategoriaUseCase.RegistrarCategoria cmd) {

        CategoriaId id = registrarCategoriaAppService.handle(cmd);

        return UriResponseBuilder.builder()
                .fullPath(fromCurrentRequest().toUriString())
                .id(id.asString())
                .build()
                .toCreated();
    }

    @GetMapping(path = "/{id}")
    public Categoria buscaPorId(@PathVariable UUID id) {
        return categoriaQueryAppService.recuperarCategoria(id);
    }







}
