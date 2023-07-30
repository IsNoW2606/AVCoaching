package org.example.model;

import org.example.contracts.ExerciceContract;

import java.util.ArrayList;
import java.util.List;
public class ExercicesList implements ExerciceContract.Model {
    private List<Exercice> exercices = new ArrayList<>();
    private List<Exercice> filtered = new ArrayList<>();

    @Override
    public List<Exercice> getAll() {
        return exercices;
    }

    @Override
    public List<Exercice> getFiltered() {
        return filtered;
    }

    @Override
    public void registerExercice(Exercice exercice) {
        exercices.add(exercice);
    }

    public void filter(String bodyPart) {
        filtered = exercices
                    .stream()
                    .filter(exercice -> exercice.isBodyPart(bodyPart))
                    .toList();
    }
}
