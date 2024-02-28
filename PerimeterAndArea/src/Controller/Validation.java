
package Controller;


import java.util.Scanner;
/**
 *
 * @author hieut
 */

public class Validation {
        private static final Scanner in = new Scanner(System.in);

    public static double checkInputDouble() {
        while (true) {
            try {
                double result = Double.parseDouble(in.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Re-input");
            }
        }
    }

}
