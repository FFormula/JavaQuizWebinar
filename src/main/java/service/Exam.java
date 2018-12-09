package service;

import model.Quiz;

public class Exam {

    private IDialog dialog;
    private Shuffler shuffler;
    private int count;

    public Exam(IDialog dialog, Shuffler shuffler) {
        this.dialog = dialog;
        this.shuffler = shuffler;
    }

    public void start(int questions) {
        if (questions <= 0) return;
        int points = 0;
        for (Quiz quiz : shuffler.getRandomList(questions)) {
            dialog.print(quiz.getQuestion() + ": ");
            String answer = dialog.input().trim();
            if (answer.equalsIgnoreCase(quiz.getAnswer()))
                points ++;
            else
                dialog.print("Правильный ответ: " + quiz.getAnswer() + "\n");
        }
        int percent = (100 * points) / questions;
        dialog.print(String.format("Ваш результат: %d%%%n", percent));
    }
}
