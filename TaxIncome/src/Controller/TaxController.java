package Controller;

import Model.TaxCalculator;
import View.TaxView;
import java.util.Scanner;

public class TaxController{
    private static final Scanner scanner = new Scanner(System.in);

    public static void run() {
        boolean continueCalculation = true;
        while (continueCalculation) {
            double totalIncome = TaxView.getUserInput("Enter Tax Income: ");
            int numberOfChildren = TaxView.getUserInputInt("Enter Number Of Children: ");
            boolean[] childrenOver18 = TaxView.getChildrenOver18Info(numberOfChildren);
            int numberOfParents = TaxView.getUserInputInt("Enter Number Of Parents: ");
            boolean[] parentsOver60 = TaxView.getParentsOver60Info(numberOfParents);

            double taxAmount = TaxCalculator.calculateTax(totalIncome, numberOfChildren, childrenOver18, numberOfParents, parentsOver60);
            TaxView.displayTaxDetails(totalIncome, numberOfChildren, childrenOver18, numberOfParents, parentsOver60, taxAmount);

            continueCalculation = askToContinue();
        }
        scanner.close();
    }

    private static boolean askToContinue() {
        System.out.println("You wanna continue? (true/false)");
        return scanner.nextBoolean();
    }
}
