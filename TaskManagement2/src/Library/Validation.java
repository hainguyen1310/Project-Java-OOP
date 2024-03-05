package Library;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Validation {
    
    private static final Scanner in = new Scanner(System.in);
    private static final String PLAN_VALID = "^[0-9]{1,2}\\.5|[0-9]{1,2}\\.0$";
    
    public static int checkIntLimit(int min, int max) {
        while (true) {
            try {
                int n = Integer.parseInt(in.nextLine());
                if (n < min || n > max) {
                    throw new NumberFormatException();
                }
                return n;
            } catch (NumberFormatException ex) {
                System.err.println("Re-input");
            }
        }
    }

    public static String checkInputDate(String result) {
        while (true) {
            try {
                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                format.setLenient(false);
                Date date = format.parse(result);
                if (result.equalsIgnoreCase(format.format(date))) {
                    return result;
                } else {
                    System.err.println("Re-input");
                }
            } catch (ParseException ex) {
                System.err.println("Re-input");
            }
        }
    }

    public static String checkInputString(String result) {
        while (true) {
            if (result.trim().length() == 0) {
                System.err.println("Not empty.");
            } else {
                return result;
            }
        }
    }

    public static int checkInputInt() {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine());
                return result;
            } catch (NumberFormatException ex) {
                System.err.println("Re-input");
            }
        }
    }

    public static String checkInputTaskTypeId() {
        while (true) {
            int n = checkIntLimit(1, 4);
            String result = null;
            switch (n) {
                case 1:
                    return result = "Code";
                case 2:
                    return result = "Test";
                case 3:
                    return result = "Manager";
                case 4:
                    return result = "Learn";
            }
        }
    }

    public static String checkInputPlan(String result) {
        while (true) {
            result = checkInputString(result);
            if (result.matches(PLAN_VALID) && Double.parseDouble(result) >= 1.0
                    && Double.parseDouble(result) <= 24.0) {
                return result;
            } else {
                System.err.println("Re-input.");
            }
        }
    }
}
