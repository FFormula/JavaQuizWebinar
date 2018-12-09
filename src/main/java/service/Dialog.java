package service;

import java.util.Scanner;

public class Dialog implements IDialog {

    private final Scanner scanner;

    public Dialog() {
        scanner = new Scanner(System.in);
    }

    public void print(String message) {
        System.out.print(message);
    }

    public String input() {
        return scanner.nextLine();
    }
}
