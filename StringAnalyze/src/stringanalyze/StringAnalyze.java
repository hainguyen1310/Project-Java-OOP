package stringanalyze;

import Controller.StringAnalyzerController;
import Model.StringAnalyzerModel;
import View.StringAnalyzerView;
import java.util.Scanner;

public class StringAnalyze {
    public static boolean checkSquareNumber(int n) {
        return Math.sqrt(n) * Math.sqrt(n) == n;
    }

    public static void main(String[] args) {
        StringAnalyzerModel model = new StringAnalyzerModel();
        StringAnalyzerView view = new StringAnalyzerView();
        StringAnalyzerController controller = new StringAnalyzerController(model, view);
        
        System.out.println("===== Analysis String program ====");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String userInput = scanner.nextLine();

        controller.analyzeAndDisplay(userInput);

        scanner.close();
    }
    
}
