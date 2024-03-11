package Controller;

import Model.EbankModel;
import View.Menu;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;

public class EbankController extends Menu{
    private EbankModel em;
    private ResourceBundle labels;
    private static final String[] mc = {"Vietnamese","English","Exit"};

    public EbankController() {
        super ("\n========Login Program========",mc);
    }
    
    public void getWordLanguage(Locale locale, String key) {
        ResourceBundle labels = ResourceBundle.getBundle("messages", locale);
        System.out.println(labels.getString(key));
    }

    public int randomRange(int min, int max) {
        Random rd = new Random();
        return rd.nextInt(max - min + 1) + min;
    }

    public String generateCaptcha() {
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String alphaNumeric = alpha + alpha.toUpperCase() + digits;

        String res = "";
        for (int i = 0; i < 5; i++) {
            res += alphaNumeric.charAt(randomRange(0, alphaNumeric.length() - 1));
        }
        return res;
    }
    
    @Override
    public void execute(int n ){
        switch (n){
            case 1:
                login(localeVi);
                break;
            case 2:
                login(localeEn);
                break;
            default:
                System.exit(0);
        }
    }
    
    public void login(Locale locale){
        em.getAccount(locale);
        em.getPassword(locale);
        em.getCaptcha(locale);
    }
}
