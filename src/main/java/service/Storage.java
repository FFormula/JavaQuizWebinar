package service;

import model.Quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Storage {

    private final String filename;
    private final IParser parser;

    public Storage(String filename, IParser parser) {
        this.filename = filename;
        this.parser = parser;
    }

    public List<Quiz> getList() {
        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                getClass().getResourceAsStream(filename)));
        List<Quiz> list = new ArrayList<>();
        try {
            while (reader.ready())
                list.add(parser.getQuiz(reader.readLine()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

}
