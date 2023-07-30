package org.example.view;

import org.example.contracts.MainContract;

import java.util.Scanner;

public class MainView implements MainContract.View {
    private ExerciceView exerciceView;

    private MainContract.Controller controller;
    public MainView(ExerciceView exerciceView) {
      this.exerciceView = exerciceView;


    }

    @Override
    public void showChoices() {
        System.out.println("1. Exercices");
        System.out.println("2. Programmes");
        System.out.println("3. Quitter");
    }

    @Override
    public int getChoices() {
        System.out.print("Choix ? : ");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        System.out.println();
        return choice;
    }

    @Override
    public void showWrongChoices() {
        System.out.println("Le choix enregistré n'existe pas");
        System.out.println();
    }

    @Override
    public void showExercices() {
        exerciceView.goTo();
    }

    @Override
    public void showProgrammes() {

    }

    @Override
    public void setController(MainContract.Controller controller) {
        this.controller = controller;
    }
}
