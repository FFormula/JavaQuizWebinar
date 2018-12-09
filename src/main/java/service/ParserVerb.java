package service;

import model.Quiz;

public class ParserVerb implements IParser {

    @Override
    public Quiz getQuiz(String line) {
        // choose,chose,chosen,выбирать
        String[] items = line.split(",", 4);
        return new Quiz(items[3],
                items[0] + " " + items[1] + " " + items[2]);
    }
}
