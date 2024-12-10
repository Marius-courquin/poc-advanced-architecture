package com.ig2I.pochexagonalarchitecture.domain.exercices;

public record ExericeRecord(int id, String name, String description, String type, String difficulty, ExerciceStatus status) {
    public ExericeRecord {
        if (status == null) {
            status = ExerciceStatus.NOT_STARTED;
        }
    }

    public ExericeRecord start() {
        return new ExericeRecord(id, name, description, type, difficulty, ExerciceStatus.IN_PROGRESS);
    }
}
