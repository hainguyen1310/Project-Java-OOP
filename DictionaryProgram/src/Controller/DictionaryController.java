package Controller;

import Model.Dictionary;
import java.util.Scanner;
import View.Utils;


public class DictionaryController {
    private Dictionary model;
    private Scanner scanner;
    
    public DictionaryController(Dictionary model) {
        this.model = model;
        this.scanner = new Scanner(System.in);
    }

    public void addWord() {
        System.out.print("Enter English Word: ");
        String engWord = scanner.nextLine();

        System.out.print("Enter vietnamese: ");
        String viWord = scanner.nextLine();

        boolean result = model.addWord(engWord, viWord);
        if (result) {
            Utils.displayResult("Add successfully.");
        } else {
            Utils.displayResult("Exist word, want to update? (Y/N): ");
            String choice = scanner.nextLine().trim().toLowerCase();

            if (choice.equals("y")) {
                result = model.addWord(engWord, viWord);
                if (result) {
                    Utils.displayResult("Update successfully.");
                } else {
                    Utils.displayResult("Update Failed.");
                }
            }
        }
    }

    public void deleteWord() {
        System.out.print("Enter English word need to delete: ");
        String engWord = scanner.nextLine();

        boolean result = model.removeWord(engWord);
        if (result) {
            Utils.displayResult("delete complete.");
        } else {
            Utils.displayResult("Invalid Word.");
        }
    }

    public void translateWord() {
        System.out.print("Enter Enlish Word: ");
        String engWord = scanner.nextLine();

        String viWord = model.translate(engWord);
        Utils.displayResult("Vietnamese: " + viWord);
    }
}