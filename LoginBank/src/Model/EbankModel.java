package Model;

import Controller.EbankController;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class EbankModel {
    private Locale currentLocale;
    private ResourceBundle resourceBundle;
    private EbankController ec;
    
    public String getString(Locale locale) {
        Scanner in = new Scanner(System.in);
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                ec.getWordLanguage(locale, "checkEmptyString");
            } else {
                return result;
            }
        }
    }

    public int getInt(Locale locale, int min, int max) {
        int number = 0;
        boolean flag = true;

        while (flag) {

            try {
                number = Integer.parseInt(getString(locale));
                if (number >= min && number <= max) {
                    flag = false;
                } else {
                    ec.getWordLanguage(locale, "checkNumberRange");
                }

            } catch (NumberFormatException e) {
                ec.getWordLanguage(locale, "checkEnterInputAgain");
            }
        }

        return number;
    }

    public String getAccount(Locale locale) {
        String account = "";
        boolean flag = true;

        while (flag) {
            ec.getWordLanguage(locale, "enterAccount");
            account = getString(locale);
            if (account.matches("\\d{10}")) {
                flag = false;
            } else {
                ec.getWordLanguage(locale, "errorAccount");
            }
        }
        return account;
    }

    private boolean isPassword(String pass) {
        int passLength = pass.length();
        boolean isPass = true;

        if (passLength >= 8 && passLength <= 31) {
            for (int i = 0; i < passLength; i++) {
                if (!Character.isLetter(pass.charAt(i)) && !Character.isDigit(pass.charAt(i))) {
                    isPass = false;
                    break;
                }
            }

            if (pass.matches("\\d+") || pass.matches("[a-zA-Z]+")) {
                isPass = false;
            }
        } else {
            isPass = false;
        }
        return isPass;
    }

    public String getPassword(Locale locale) {
        String password = "";
        boolean flag = true;

        while (flag) {
            ec.getWordLanguage(locale, "enterPassword");
            password = getString(locale);
            if (isPassword(password)) {
                flag = false;
            } else {
                ec.getWordLanguage(locale, "errorPassword");
            }
        }
        return password;
    }

    public String getCaptcha(Locale locale) {
        boolean flag = true;
        String captchaInput = "";
        String captchaGenerated = "";

        while (flag) {
            captchaGenerated = ec.generateCaptcha();
            System.out.println(captchaGenerated);

            ec.getWordLanguage(locale, "enterCaptcha");
            captchaInput = getString(locale);

            if (captchaGenerated.equals(captchaInput)) {
                ec.getWordLanguage(locale, "loginSuccess");
                flag = false;
            } else {
                ec.getWordLanguage(locale, "errorCaptcha");
            }
        }

        return captchaInput;
    }
}
