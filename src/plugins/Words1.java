package plugins;

import interfaces.TFWords;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;

public class Words1 implements TFWords {
    @Override
    public List<String> extractWords(String path) throws IOException {
        // Read the input file
        Path filePath = Path.of(path);
        String text = Files.readString(filePath);

        // Replace non-word characters, lower, adn split
        String[] words = text
                .replaceAll("[\\W_]+", " ")
                .toLowerCase()
                .trim()
                .split("\\s+");

        // Load the stop words
        // Read the stop words file
        Path stopPath = Path.of("../stop_words.txt");
        String stopText = Files.readString(stopPath);

        // Split on commas
        String[] stopArray = stopText.trim().split(",");

        // Create a set for the stop words
        Set<String> stopWords = new HashSet<>();

        // Add the stop words to the set
        for (String stop : stopArray) {
            stopWords.add(stop);
        }

        // Add single letters a-z
        for (char letter='a'; letter<='z'; letter++) {
            stopWords.add(String.valueOf(letter));
        }

        // Filter
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (! stopWords.contains(word)) {
                result.add(word);
            }
        }
        return result;
    }
}
