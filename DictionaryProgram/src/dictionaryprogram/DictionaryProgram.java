package dictionaryprogram;

import View.Menu;
import Controller.DictionaryController;
import Model.Dictionary;

public class DictionaryProgram extends Menu {
    private DictionaryController dc;
    private static String[] mc = {"Add new word", "Delete word","Search word", "Exit"};

    public DictionaryProgram() {
        super("\nDictionary Program",mc);
        this.dc = new DictionaryController(new Dictionary());
    }

    public static void main(String[] args) {
        new DictionaryProgram().run();
    }
    
            @Override
        public void execute(int n) {
            switch (n) {
                case 1:
                    dc.addWord();
                    break;
                case 2:
                    dc.deleteWord();
                    break;
                case 3:
                    dc.translateWord();
                    break;
                default:
                    System.out.println("See you again, Goodbye!!!");
                    System.exit(0);
                    break;
            }
        }

}
