package com.ig2I.pochexagonalarchitecture.domain.exercices;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ExerciceService implements IExerciceService {
    private final ExerciceRepository repository;

    public ExerciceService(ExerciceRepository repository) {
        this.repository = repository;
    }

    @Override
    public Exercice startExercice(String id) {
        Exercice exercice = repository.getExerciceById(id);
        exercice.started();
        return repository.updateExercice(exercice);
    }
}
