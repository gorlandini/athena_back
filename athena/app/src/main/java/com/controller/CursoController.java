package com.controller;

import com.controller.response.ApiResponse;
import com.query.domain.curso.app.CursoQueryAppService;
import com.query.domain.curso.projection.Curso;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor

@Tag(name = "CursoController", description = "API para gerenciar cursos")
@RestController
@RequestMapping("/api/v1/cursos")
public class CursoController {

    private final CursoQueryAppService cursoQueryAppService;


    @GetMapping
    public ResponseEntity<ApiResponse<List<Curso>>> listAll() {

        var cursos = cursoQueryAppService.findAll();

        return ResponseEntity.ok(
                ApiResponse.success(cursos)
        );
    }


}
