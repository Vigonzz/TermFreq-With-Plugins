// Violet Gonzalez
// November 8, 2026
// Professor Cristina Videria Lopes SWE 262P


package interfaces;

import java.util.List;
import java.util.Map;

public interface TFFreqs {
    public List<Map.Entry<String, Integer>> top25(List<String> wordList);
}
