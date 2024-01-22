package normalizetext;

import Controller.TextFileController;
import Model.TextFileModel;
import View.Menu;
import View.Utils;

public class NormalizeText extends Menu{
    private TextFileModel model;
    private Utils view;
    private TextFileController tc;
    private static String[] mc = {"Read File","Write File","Normalize Text","Exit"};
    
    public NormalizeText(){
        super("\nNormalize Text App",mc);
        this.model = new TextFileModel();
        this.view = new Utils();
        this.tc = new TextFileController(model,view);
    }
    public static void main(String[] args) {
        new NormalizeText().run();
    }
    
    @Override
    public void execute(int n) {
        String a = "input.txt";
        String b = "output.txt";
        switch (n) {
            case 1:
                tc.readFile(a);
                break;

            case 2:
                tc.writeFile(b);
                break;
            case 3:
                tc.normalizeText();
                break;
            default:
                System.out.println("See you again, Goodbye!!!");
                System.exit(0);
                break;
        }
    }
}
