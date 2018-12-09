package service;

import model.Quiz;

public class ParserWordReverse extends ParserWord {

    @Override
    public Quiz getQuiz(String line) {
        Quiz quiz = super.getQuiz(line);
        return new Quiz(quiz.getAnswer(), quiz.getQuestion());
    }
}
