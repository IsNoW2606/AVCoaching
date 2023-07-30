package org.example.controller;

import org.example.contracts.ExerciceContract;
import org.example.model.Difficulty;
import org.example.model.Exercice;

public class ExerciceController implements ExerciceContract.Controller {
    private ExerciceContract.Model model;
    private ExerciceContract.View view;
    public ExerciceController(ExerciceContract.Model model, ExerciceContract.View view) {
        this.model = model;
        this.view = view;

        view.setController(this);
    }

    @Override
    public void onEnter() {
        while (true) {
            view.showChoices();

            int choice = view.getChoices();
            switch (choice) {
                case 1: view.showCreateExercice();
                    break;
                case 2: view.showExercices(model.getAll());
                    break;
                case 3: return;
                default: view.showWrongChoices();
            }
        }
    }

    @Override
    public void createExercice(String name, String bodyPart, int difficulty) {
        Exercice exercice = new Exercice(name, bodyPart, Difficulty.values()[difficulty - 1]);

        model.registerExercice(exercice);
    }
}
