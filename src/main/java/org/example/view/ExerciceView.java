package org.example.view;

import org.example.Main;
import org.example.contracts.ExerciceContract;
import org.example.model.Exercice;

import java.util.List;
import java.util.Scanner;

public class ExerciceView implements ExerciceContract.View {
    private String exercicesList;

    private ExerciceContract.Controller controller;

    public void goTo() {
        controller.onEnter();
    }

    @Override
    public void showChoices() {
        System.out.println("1. Poster exercices");
        System.out.println("2. Voir liste des exercices");
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
    public void showExercices(List<Exercice> exerciceList) {
        int[] maxLength = getMaxLength(exerciceList);

        System.out.printf("| %-" + maxLength[0] + "s | %-" + maxLength[1] + "s | %-" + maxLength[2] + "s |\n", "NAME", "BODYPART", "DIFFICULTY");
        for (Exercice exercice : exerciceList) {
            System.out.printf("| %-" + maxLength[0] + "s | %-" + maxLength[1] + "s | %-" + maxLength[2] + "s |\n", exercice.getName(), exercice.getBodyPart(), exercice.getDifficulty());
        }

        System.out.println();
    }

    private int[] getMaxLength(List<Exercice> exerciceList) {
        int[] maxLength = new int[] { 4, 8, 10 };

        for (Exercice exercice : exerciceList) {
            maxLength[0] = Math.max(exercice.getName().length(), maxLength[0]);
            maxLength[1] = Math.max(exercice.getBodyPart().length(), maxLength[1]);
            maxLength[2] = Math.max(exercice.getDifficulty().length(), maxLength[2]);
        }

        return maxLength;
    }

    @Override
    public void showCreateExercice() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nom de l'exercice: ");
        String name = scanner.next();

        System.out.print("Partie du corp entrainée: ");
        String bodyPart = scanner.next();

        int difficulty;
        do {
            System.out.println("1. Facile");
            System.out.println("2. Normale");
            System.out.println("3. Difficile");
            System.out.print("Choix: ");
            difficulty = scanner.nextInt();
        } while (difficulty < 1 || difficulty > 3);

        controller.createExercice(name, bodyPart, difficulty);
        System.out.println();
    }

    @Override
    public void setController(ExerciceContract.Controller controller) {
        this.controller = controller;
    }
}
