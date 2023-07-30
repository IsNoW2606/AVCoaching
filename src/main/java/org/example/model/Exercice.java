package org.example.model;

public class Exercice {
    private String name;
    private String bodyPart;
    private Difficulty difficulty;

    public Exercice(String name, String bodyPart, Difficulty difficulty) {
        this.name = name;
        this.bodyPart = bodyPart;
        this.difficulty = difficulty;
    }

    public boolean isBodyPart(String bodyPart) {
        return this.bodyPart.equals(bodyPart);
    }

    public String getName() {
        return name;
    }

    public String getBodyPart() {
        return bodyPart;
    }

    public String getDifficulty() {
        return difficulty.name();
    }
}
