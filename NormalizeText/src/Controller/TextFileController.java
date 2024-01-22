package Controller;

import Model.TextFileModel;
import View.Utils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextFileController {
    private TextFileModel model;
    private Utils view;

    public TextFileController(TextFileModel model, Utils view) {
        this.model = model;
        this.view = view;
    }
    

    public void readFile(String filePath) {
        try {
            String content = readTextFile(filePath);
            model.setContent(content);
            System.out.println("File content read successfully.");
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
    }

    public void writeFile(String filePath) {
        try {
            writeTextFile(filePath, model.getContent());
            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    public void normalizeText() {
        String normalizedContent = normalizeContent(model.getContent());
        model.setContent(normalizedContent);
        System.out.println("Text normalized successfully.");
    }

    private String readTextFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }

    private String normalizeContent(String input) {
        // Implement the normalization rules here
        // Rule 1: Only one space between words
        input = input.replaceAll("\\s+", " ");

        // Rule 2: Only one space after comma (,), dot (.) and colon (:).
        // First character of the word after dot is in Uppercase and others are in lowercase.
        input = input.replaceAll("(\\.|,|:)\\s*([a-zA-Z])", ". $2");

        // Rule 3: No spaces before and after sentence or word phrases in quotes (“”).
        input = input.replaceAll("\"\\s*([^\\s\"]*)\\s*\"", "\"$1\"");

        // Rule 4: First character of the word in the first line is in Uppercase.
        String[] lines = input.split("\n");
        if (lines.length > 0) {
            lines[0] = capitalizeFirstWord(lines[0]);
        }
        input = String.join("\n", lines);

        // Rule 5: No space between comma or dot and the word in front of it.
        input = input.replaceAll("(\\.|,)\\s+([a-zA-Z])", "$1$2");

        // Rule 6: Must have a dot at the end of the text.
        if (!input.endsWith(".")) {
            input += ".";
        }

        return input;
    }
    
    private String capitalizeFirstWord(String line) {
        if (!line.isEmpty()) {
            return line.substring(0, 1).toUpperCase() + line.substring(1);
        }
        return line;
    }
    
    private void writeTextFile(String filePath, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
        }
    }
}

