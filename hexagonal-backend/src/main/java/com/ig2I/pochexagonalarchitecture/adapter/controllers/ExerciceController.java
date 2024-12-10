package com.ig2I.pochexagonalarchitecture.adapter.controllers;

import com.ig2I.pochexagonalarchitecture.domain.exercices.IExerciceService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/exercices")
public class ExerciceController {
    private final IExerciceService service;

    public ExerciceController(IExerciceService exerciceService) {
        this.service = exerciceService;
    }

    @PostMapping("/{id}/start")
    public void startExercice(@PathVariable String id) {
        service.startExercice(id);
    }
}
