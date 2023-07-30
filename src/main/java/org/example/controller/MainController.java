package org.example.controller;

import org.example.contracts.MainContract;

public class MainController implements MainContract.Controller {
    private MainContract.View view;

    public MainController(MainContract.View view) {
        this.view = view;

        view.setController(this);
    }

    public void onEnter() {
        while (true) {
            view.showChoices();

            int choice = view.getChoices();
            switch (choice) {
                case 1: view.showExercices();
                    break;
                case 2: view.showProgrammes();
                    break;
                case 3: return;
                default: view.showWrongChoices();
            }
        }
    }
}
