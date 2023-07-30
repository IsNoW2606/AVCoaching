package org.example.contracts;

import org.example.model.Exercice;

import java.util.List;

public interface ExerciceContract {
    interface Model {
        List<Exercice> getAll();
        List<Exercice> getFiltered();
        void registerExercice(Exercice exercice);
    }

    interface View {
        void showChoices();
        int getChoices();
        void showWrongChoices();
        void showExercices(List<Exercice> exerciceList);
        void showCreateExercice();
        void setController(Controller controller);
    }

    interface Controller {
        void onEnter();
        void createExercice(String name, String bodyPart, int difficulty);
    }
}
