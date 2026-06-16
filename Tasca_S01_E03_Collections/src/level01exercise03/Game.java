package level01exercise03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Game {

    private static final int TOTAL_QUESTIONS = 10;

    private final UI userInterface;
    private final FileInteraction fileInteraction;
    private Map<String, String> countryCapitalMap;
    private List<String> countriesList;

    public Game() {
        this.userInterface = new UI();
        this.fileInteraction = new FileInteraction();
    }

    public void start() {
        countryCapitalMap = fileInteraction.loadCountries();

        if (countryCapitalMap.isEmpty()) {
            userInterface.showMessage("ERROR: No countries found.");
            return;
        }

        countriesList = new ArrayList<>(countryCapitalMap.keySet());

        boolean playAgain;
        do {
            playOneGame();
            playAgain = userInterface.askYesOrNo("Do you want to keep playing?");
        } while (playAgain);

        userInterface.showMessage("Good Bye.");
        userInterface.close();
    }

    private void playOneGame() {
        String playerName = userInterface.readString("Enter your name: ");

        Collections.shuffle(countriesList);

        int available = countriesList.size();
        int questionsThisGame = Math.min(TOTAL_QUESTIONS, available);
        List<String> selectedCountries = countriesList.subList(0, questionsThisGame);

        if (available < TOTAL_QUESTIONS) {
            userInterface.showMessage("Only " + available + " countries available.");
        }

        int score = playGame(selectedCountries);

        userInterface.showGameScore(playerName, score, questionsThisGame);

        if (questionsThisGame > 0) {
            fileInteraction.saveScore(playerName, score);
            userInterface.showMessage("Score saved to clasificacion.txt");
        }
    }

    private int playGame(List<String> selectedCountries) {
        int score = 0;

        for (String country : selectedCountries) {
            String correctCapital = countryCapitalMap.get(country);
            String displayCountry = country.replace("_", " ");
            String answer = userInterface.readString("What's the capital of " + displayCountry + "?");

            if (isAnswerCorrect(correctCapital, answer)) {
                userInterface.showMessage("Correct answer! +1 point\n");
                score++;
            } else {
                String displayCapital = correctCapital.replace("_", " ");
                userInterface.showMessage(
                        "Wrong. The capital of " + displayCountry + " is " + displayCapital + ".\n"
                );
            }
        }

        return score;
    }

    private boolean isAnswerCorrect(String correctCapital, String userAnswer) {
        String normalizedCorrect = normalize(correctCapital);
        String normalizedUser = normalize(userAnswer);
        return normalizedCorrect.equals(normalizedUser);
    }

    private String normalize(String text) {
        return text.toLowerCase()
                .replace('_', ' ')
                .replaceAll("\\s+", " ")
                .trim();
    }
}