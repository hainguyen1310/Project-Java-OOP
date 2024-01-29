package View;

import Model.CalculatorModel;
import Model.CalculatorModel.Operator;
import java.util.List;
import java.util.Scanner;

public class Utils {

    public static String getString(String msg) {
        Scanner sc = new Scanner(System.in);
        System.out.println(msg + ": ");
        return sc.nextLine().trim();
    }

    public static int getInt(String msg) {
        return Integer.parseInt(getString(msg));
    }
    
    public static float getFloat(String msg) {
        return Float.parseFloat(getString(msg));
    }
    
    public static double getDouble(String msg) {
        return Double.parseDouble(getString(msg));
    }
    
    public static String getOperatorSymbolInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter operator (+, -, *, /, ^, =): ");
        String operator = scanner.next();

        // Validate operator
        while (Operator.fromSymbol(operator) == null) {
            System.out.println("Invalid operator. Please enter a valid operator.");
            System.out.print("Enter operator (+, -, *, /, ^, =): ");
            operator = scanner.next();
        }

        return operator;
    }
    
    public static void displayResult(double result) {
        System.out.println("Result: " + result);
    }

    public static void displayBMIStatus(CalculatorModel.BMI bmiStatus) {
        System.out.println("BMI Status: " + bmiStatus);
    }
}