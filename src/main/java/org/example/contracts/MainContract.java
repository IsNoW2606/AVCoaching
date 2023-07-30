package org.example.contracts;

import org.example.model.Exercice;

import java.util.List;
import java.util.Scanner;

public interface MainContract {
    interface View {
        void showChoices();
        int getChoices();
        void showWrongChoices();
        void showExercices();
        void showProgrammes();
        void setController(Controller controller);
    }

    interface Controller {

    }
}
