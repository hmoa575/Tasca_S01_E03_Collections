package level01exercise03;

import java.util.Scanner;

public class UI {
    private final Scanner SCANNER = new Scanner(System.in);

    public UI() {
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showFormattedMessage(String format, Object... args) {
        System.out.printf(format, args);
    }

    public String readString(String prompt) {
        System.out.println(prompt);
        String input = SCANNER.nextLine().trim();
        while (input.isEmpty()) {
            System.out.println("It cannot be empty.");
            input = SCANNER.nextLine().trim();
        }
        return input;
    }

    public boolean askYesOrNo(String prompt) {
        while (true) {
            String answer = readString(prompt + " -y or n-:");
            if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes")) {
                return true;
            } else if (answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("no")) {
                return false;
            } else {
                System.out.println("Type: 'y' or 'n'");
            }
        }
    }

    public void showGameScore(String playerName, int score, int totalQuestions) {
        System.out.println("Player: " + playerName);
        System.out.println("Final Score: " + score);
        System.out.println("Total Questions: " + totalQuestions);
    }

    public void close() {
        SCANNER.close();
    }
}