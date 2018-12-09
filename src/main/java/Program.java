import model.Word;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
            new BufferedReader(
                new InputStreamReader(
                    Program.class
                        .getResourceAsStream("words.csv")));
        List<Word> list = new ArrayList<>();
        while (reader.ready()) {
            String[] items = reader.readLine().split(",", 2);
            Word word = new Word(items[0].trim(), items[1].trim());
            list.add(word);
        }
        int count =  5;
        Collections.shuffle(list);
        list = list.subList(0, count);
        Scanner scanner = new Scanner(System.in);
        int points = 0;
        for (Word word : list) {
            System.out.print(word.russian + ": ");
            String answer = scanner.nextLine().trim();
            if (answer.equalsIgnoreCase(word.english))
                points ++;
            else
                System.out.println("Правильный ответ: " + word.english);
        }
        int percent = (100 * points) / count;
        System.out.println("Ваш результат: " + percent + "%");
    }
}