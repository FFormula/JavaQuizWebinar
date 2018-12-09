package service;

import model.Quiz;
import java.util.Collections;
import java.util.List;

public class Shuffler {

    private Storage storage;

    public Shuffler(Storage storage) {
        this.storage = storage;
    }

    public List<Quiz> getRandomList(int count) {
        List<Quiz> list = storage.getList();
        Collections.shuffle(list);
        if (count < 0) count = 0;
        if (count > list.size()) count = list.size();
        return list.subList(0, count);
    }
}
