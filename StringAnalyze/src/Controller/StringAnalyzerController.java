package Controller;

import Model.StringAnalyzerModel;
import View.StringAnalyzerView;
import java.util.List;
import java.util.Map;

public class StringAnalyzerController {
    private StringAnalyzerModel model;
    private StringAnalyzerView view;

    public StringAnalyzerController(StringAnalyzerModel model, StringAnalyzerView view) {
        this.model = model;
        this.view = view;
    }

    public void analyzeAndDisplay(String input) {
        System.out.println("-----Result Analysis------");
        Map<String, List<Integer>> numberAnalysis = model.analyzeNumbers(input);
        view.displayNumberAnalysis(numberAnalysis);

        Map<String, String> characterAnalysis = model.analyzeCharacters(input);
        view.displayCharacterAnalysis(characterAnalysis);
    }
}
