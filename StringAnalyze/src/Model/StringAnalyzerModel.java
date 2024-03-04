package Model;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import stringanalyze.StringAnalyze;

public class StringAnalyzerModel {
    
    public Map<String, List<Integer>> analyzeNumbers(String input) {
        List<Integer> allNumbers = Arrays.stream(input.split("\\D+"))
                .filter(s -> !s.isEmpty())
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> perfectSquareNumbers = allNumbers.stream()
                .filter(StringAnalyze::checkSquareNumber)
                .collect(Collectors.toList());

        List<Integer> oddNumbers = allNumbers.stream().filter(n -> n % 2 == 1).collect(Collectors.toList());
        List<Integer> evenNumbers = allNumbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());

        Map<String, List<Integer>> resultMap = new LinkedHashMap<>();
        resultMap.put("Perfect Square Numbers", perfectSquareNumbers);
        resultMap.put("Odd Numbers", oddNumbers);
        resultMap.put("Even Numbers", evenNumbers);
        resultMap.put("All Numbers", allNumbers);

        return resultMap;
    }

    public Map<String, String> analyzeCharacters(String input) {
        Map<String, String> resultMap = new LinkedHashMap<>();

        String uppercase = input.replaceAll("\\W|[0-9]|[a-z]", "");
        String lowercase = input.replaceAll("\\W|[0-9]|[A-Z]", "");
        String special = input.replaceAll("\\w", "");
        String allCharacters = input.replaceAll("\\W", "");

        resultMap.put("Uppercase", uppercase);
        resultMap.put("Lowercase", lowercase);
        resultMap.put("Special", special);
        resultMap.put("All Characters", allCharacters);

        return resultMap;
    }
}
