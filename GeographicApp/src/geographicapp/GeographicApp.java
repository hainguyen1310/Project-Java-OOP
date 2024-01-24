package geographicapp;

import Controller.ManageEastAsiaCountries;
import View.Menu;

public class GeographicApp extends Menu {
    private ManageEastAsiaCountries me;
    private static String[] mc = {"Input the information of 11 countries in East Asia", "Display the information of country you've just input", 
        "Search the information of country by user-entered name","Display the information of countries sorted name in ascending order","Exit"};
    
    public GeographicApp(){
        super("\nMenu",mc);
        this.me = new ManageEastAsiaCountries();
    }
    
    public static void main(String[] args) {
        new GeographicApp().run();
    }
    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                me.addCountryInformation();
                break;
            case 2:
                me.displayCountry();
                break;
            case 3:
                me.searchCountry();
                break;
            case 4:
                me.sortCountries();
                break;
            default:
                System.out.println("See you again, Goodbye!!!");
                System.exit(0);
                break;
        }
    }
}
