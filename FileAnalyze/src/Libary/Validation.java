package Libary;

import java.util.Scanner;

public class Validation {
    private static final Scanner in = new Scanner(System.in);
    
    public static String checkInputString() {
        while (true) {
            String result = in.nextLine().trim();
            if (result.length() == 0) {
                System.err.println("Not empty.");
            } else {
                return result;
            }
        }
    }
}
