package org.example;

import org.example.controller.ExerciceController;
import org.example.controller.MainController;
import org.example.model.ExercicesList;
import org.example.view.ExerciceView;
import org.example.view.MainView;

public class Main {
    public static void main(String[] args) {
        ExerciceView exerciceView = new ExerciceView();
        ExerciceController exerciceController = new ExerciceController(new ExercicesList(), exerciceView);
        new MainController(new MainView(exerciceView)).onEnter();
    }
}