package View;

import java.util.HashMap;
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
    public static double getDouble(String msg) {
        return Double.parseDouble(getString(msg));
    }
    
  public static void displayResult(String result) {
        System.out.println(result);
    }

    public static void displayDictionary(HashMap<String, String> dictionary) {
        System.out.println("Từ điển hiện tại:");
        for (HashMap.Entry<String, String> entry : dictionary.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }   
}
}
