package View;

import java.util.Scanner;

public class TaxView {
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void displayTaxDetails(double totalIncome, int numberOfChildren, boolean[] childrenOver18,
            int numberOfParents, boolean[] parentsOver60, double taxAmount) {
        System.out.println("Total Income: " + totalIncome);
        System.out.println("Number Of Children: " + numberOfChildren);
        System.out.println("number Of Parents: " + numberOfParents);

        System.out.println("\nDeduction:");
        System.out.println("- Self Deduction: 11,000,000 VND");
        System.out.println("- Deduction for child:");
        for (int i = 0; i < numberOfChildren; i++) {
            System.out.println("  + Child " + (i + 1) + ": " + (childrenOver18[i] ? "Student" : "Under 18 years old"));
        }
        System.out.println("- Deduction for parents:");
        for (int i = 0; i < numberOfParents; i++) {
            System.out.println("  + Parents " + (i + 1) + ": " + (parentsOver60[i] ? "Over 60 years old" : "Under 60 years old"));
        }

        System.out.println("\nTotal Tax Amount: " + taxAmount + " VND");
    }

    public static double getUserInput(String message) {
        System.out.println(message);
        return scanner.nextDouble();
    }

    public static int getUserInputInt(String message) {
        System.out.println(message);
        return scanner.nextInt();
    }

    public static boolean[] getChildrenOver18Info(int numberOfChildren) {
        boolean[] childrenOver18 = new boolean[numberOfChildren];
        for (int i = 0; i < numberOfChildren; i++) {
            System.out.println("Child " + (i + 1) + " are studying (true/false): ");
            childrenOver18[i] = scanner.nextBoolean();
        }
        return childrenOver18;
    }

    public static boolean[] getParentsOver60Info(int numberOfParents) {
        boolean[] parentsOver60 = new boolean[numberOfParents];
        for (int i = 0; i < numberOfParents; i++) {
            System.out.println("Parents " + (i + 1) + " Over 60 years old (true/false): ");
            parentsOver60[i] = scanner.nextBoolean();
        }
        return parentsOver60;
    }
}
