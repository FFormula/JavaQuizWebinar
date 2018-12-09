import service.*;

import java.io.IOException;

public class Program {
    public static void main(String[] args) {
        IParser parser = new ParserVerb();
        Storage storage = new Storage(args[0], parser);
        Shuffler shuffler = new Shuffler(storage);
        IDialog dialog = new DialogStream(System.in, System.out);
        Exam exam = new Exam(dialog, shuffler);
        exam.start(3);
    }
}