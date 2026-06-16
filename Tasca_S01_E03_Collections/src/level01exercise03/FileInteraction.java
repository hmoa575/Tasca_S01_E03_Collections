package level01exercise03;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FileInteraction {

    private static final String COUNTRIES_FILE_TXT = "/countries.txt";
    private static final String RESULTS_FILE_TXT = "clasificacion.txt";

    public Map<String, String> loadCountries() {
        Map<String, String> map = new HashMap<>();

        try (InputStream inputStream = getClass().getResourceAsStream(COUNTRIES_FILE_TXT)) {

            if (inputStream == null) {
                System.err.println("File not found in resources: " + COUNTRIES_FILE_TXT);
                return map;
            }

            try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
                String line;

                while ((line = br.readLine()) != null) {
                    line = line.trim();

                    if (line.isEmpty()) {
                        continue;
                    }

                    String[] parts = line.split("\\s+", 2);

                    if (parts.length == 2) {
                        String country = parts[0].trim();
                        String capital = parts[1].trim();
                        map.put(country, capital);
                    } else {
                        System.out.println("Skipping wrong line: " + line);
                    }
                }
            }

        } catch (IOException exception) {
            System.err.println("Error reading countries file: " + exception.getMessage());
        }

        return map;
    }

    public void saveScore(String playerName, int score) {
        try (FileWriter fw = new FileWriter(RESULTS_FILE_TXT, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {

            out.println(playerName + " *** " + score + " *** Points ***");

        } catch (IOException exception) {
            System.err.println("Error saving result or score: " + exception.getMessage());
        }
    }
}