package com.ig2I.pochexagonalarchitecture.domain.exercices;

public class Exercice {
    private int id;
    private String name;
    private String description;
    private String type;
    private String difficulty;
    private ExerciceStatus status;

    public void started() {
        this.status = ExerciceStatus.IN_PROGRESS;
    }

    public Exercice(int id, String name, String description, String type, String difficulty, ExerciceStatus status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.difficulty = difficulty;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public ExerciceStatus getStatus() {
        return status;
    }

    public void setStatus(ExerciceStatus status) {
        this.status = status;
    }
}
