package com.ig2I.pochexagonalarchitecture.domain.exercices;

public interface ExerciceRepository {
    Exercice getExerciceById(String id);
    Exercice updateExercice(Exercice exercice);
}
