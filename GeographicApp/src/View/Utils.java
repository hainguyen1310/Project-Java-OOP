package View;

import java.util.Scanner;

public class Utils {

    public static String getString(String msg) {
        Scanner sc = new Scanner(System.in);
        System.out.println(msg + ": ");
        return sc.nextLine().trim();
    }

    public static int getInt(String msg) {
        try {
            return Integer.parseInt(getString(msg));
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid integer.");
            return getInt(msg);
        }
    }
    
    public static float getFloat(String msg) {
        try {
            return Float.parseFloat(getString(msg));
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            return getFloat(msg);
        }
    }
}
