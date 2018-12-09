package service;

import model.Quiz;

public class ParserWord implements IParser {

    @Override
    public Quiz getQuiz(String line) {
        String[] items = line.split(",", 2);
        return new Quiz(items[0].trim(), items[1].trim());
    }
}
