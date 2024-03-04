package View;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DataView {
    private static final String PHONE_VALID = "^[0-9]{10}$";
    private static final String EMAIL_VALID = "^[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}$";
    
    public String getInputString() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String result = scanner.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty.");
            } else {
                return result;
            }
        }
    }

    public String getInputPhone() {
        while (true) {
            try {
                String phoneCheck = getInputString();
                if (phoneCheck.matches(PHONE_VALID)) {
                    return phoneCheck;
                } else {
                    System.err.println("Phone number must be 10 digits");
                }
            } catch (NumberFormatException ex) {
                System.err.println("Phone number must be numeric");
            }
        }
    }

    public String getInputDate() {
        while (true) {
            try {
                String dateCheck = getInputString();
                Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateCheck);
                return dateCheck;
            } catch (ParseException ex) {
                System.out.print("Date: ");
                System.err.println("Date in correct format (dd/MM/yyyy)");
            }
        }
    }

    public String getInputEmail() {
        while (true) {
            String emailCheck = getInputString();
            if (!emailCheck.matches(EMAIL_VALID)) {
                System.err.println("Email must be in correct format");
                System.out.print("Email: ");
            } else {
                return emailCheck;
            }
        }
    }
}
