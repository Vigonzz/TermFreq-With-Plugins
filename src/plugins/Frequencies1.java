package plugins;

import interfaces.TFFreqs;

import java.util.*;


public class Frequencies1 implements TFFreqs {
    @Override
    public List<Map.Entry<String, Integer>> top25(List<String> wordList) {

        // Map from each word to its count
        Map<String, Integer> wordFreqs = new HashMap<>();

        // Count how many times each word appears
        for (String word : wordList) {
            if (wordFreqs.containsKey(word)) {
                wordFreqs.put(word, wordFreqs.get(word) + 1);
            } else {
                wordFreqs.put(word,1);
            }
        }
        // Turn the count into a list
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(wordFreqs.entrySet());

        // Sort it
        sortedList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        // Return the top 25 words
        return sortedList.subList(0, Math.min(25, sortedList.size()));
    }
}
