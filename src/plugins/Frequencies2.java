package plugins;

import interfaces.TFFreqs;

import java.util.*;

// Count words by their first letter
public class Frequencies2 implements TFFreqs {
    @Override
    public List<Map.Entry<String, Integer>> top25(List<String> wordList) {

        // Map from each word to its count
        Map<String, Integer> letterFreqs = new HashMap<>();

        // Count how many words starts with each letter
        for (String word : wordList) {
            // Get the first letter of each word
            String firstLetter = word.substring(0,1);
            //Skip words that are not letters to stay true to the assignment
            if (! Character.isLetter(word.charAt(0))) {
                continue;
            }
            if (letterFreqs.containsKey(firstLetter)) {
                letterFreqs.put(firstLetter, letterFreqs.get(firstLetter) + 1);
            } else {
                letterFreqs.put(firstLetter,1);
            }
        }
        // Turn the count into a list
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(letterFreqs.entrySet());

        // Sort it
        sortedList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        // Return all letter counts
        return sortedList;
    }
}
