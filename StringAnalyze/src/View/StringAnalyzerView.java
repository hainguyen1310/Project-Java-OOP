package View;

import java.util.List;
import java.util.Map;

public class StringAnalyzerView {
    public void displayNumberAnalysis(Map<String, List<Integer>> numberAnalysis) {
        for (Map.Entry<String, List<Integer>> entry : numberAnalysis.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public void displayCharacterAnalysis(Map<String, String> characterAnalysis) {
        for (Map.Entry<String, String> entry : characterAnalysis.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
