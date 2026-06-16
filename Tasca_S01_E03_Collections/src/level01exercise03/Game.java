package level01exercise03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Game {

    private static final int TOTAL_QUESTIONS = 10;

    private final UI USERINTERFACE;
    private final FileInteraction FILEINTERACTION;
    private Map<String, String> countryCapitalMap;
    private List<String> countriesList;

    public Game() {
        this.USERINTERFACE = new UI();
        this.FILEINTERACTION = new FileInteraction();
    }

    public void start() {
        countryCapitalMap = FILEINTERACTION.loadCountries();

        if (countryCapitalMap.isEmpty()) {
            USERINTERFACE.showMessage("ERROR: No countries found.");
            return;
        }

        countriesList = new ArrayList<>(countryCapitalMap.keySet());

        boolean playAgain;
        do {
            playOneGame();
            playAgain = USERINTERFACE.askYesOrNo("Do you want to keep playing?");
        } while (playAgain);

        USERINTERFACE.showMessage("Good Bye.");
        USERINTERFACE.close();
    }

    private void playOneGame() {
        String playerName = USERINTERFACE.readString("Enter your name: ");

        Collections.shuffle(countriesList);

        int available = countriesList.size();
        int questionsThisGame = Math.min(TOTAL_QUESTIONS, available);
        List<String> selectedCountries = countriesList.subList(0, questionsThisGame);

        if (available < TOTAL_QUESTIONS) {
            USERINTERFACE.showMessage("Only " + available + " countries available.");
        }

        int score = playGame(selectedCountries);

        USERINTERFACE.showGameScore(playerName, score, questionsThisGame);

        if (questionsThisGame > 0) {
            FILEINTERACTION.saveScore(playerName, score);
            USERINTERFACE.showMessage("Score saved to clasificacion.txt");
        }
    }

    private int playGame(List<String> selectedCountries) {
        int score = 0;

        for (String country : selectedCountries) {
            String correctCapital = countryCapitalMap.get(country);
            String displayCountry = country.replace("_", " ");
            String answer = USERINTERFACE.readString("What's the capital of " + displayCountry + "?");

            if (isAnswerCorrect(correctCapital, answer)) {
                USERINTERFACE.showMessage("Correct answer! +1 point\n");
                score++;
            } else {
                String displayCapital = correctCapital.replace("_", " ");
                USERINTERFACE.showMessage(
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