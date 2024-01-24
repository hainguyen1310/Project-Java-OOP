package View_Controller;

import Model.EquationModel;
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
    public static void displayResults(List<Float> solutions, float... coefficients) {
        if (solutions == null) {
            System.out.println("No solution");
        } else if (solutions.isEmpty()) {
            System.out.println("Infinitely many solutions");
        } else {
            for (int i = 0; i < solutions.size(); i++) {
                System.out.println("Solution x" + (i + 1) + " = " + String.format("%.3f", solutions.get(i)));
            }
        }

        displayNumberProperties(solutions,coefficients);
    }


    private static void displayNumberProperties(List<Float> solutions, float... coefficients) {
        System.out.print("Number is Odd:");
        for (float coefficient : coefficients) {
            if (EquationModel.isOdd(coefficient)) {
                System.out.print(" " + String.format("%.2f", coefficient)+",");
            }
        }
        for (float solution : solutions) {
            if (EquationModel.isOdd(solution)) {
                System.out.print(" " + String.format("%.2f", solution)+",");
            }
        }
        System.out.println();

        System.out.print("Number is Even:");
        for (float coefficient : coefficients) {
            if (EquationModel.isEven(coefficient)) {
                System.out.print(" " + String.format("%.2f", coefficient));
            }
        }
        for (float solution : solutions) {
            if (EquationModel.isEven(solution)) {
                System.out.print(" " + String.format("%.2f", solution)+",");
            }
        }
        System.out.println();

        System.out.print("Number is Perfect Square:");
        for (float coefficient : coefficients) {
            if (EquationModel.isPerfectSquare(coefficient)) {
                System.out.print(" " + String.format("%.2f", coefficient));
            }
        }
        for (float solution : solutions) {
            if (EquationModel.isPerfectSquare(solution)) {
                System.out.print(" " + String.format("%.2f", solution)+",");
            }
        }
        System.out.println();
    }
}
