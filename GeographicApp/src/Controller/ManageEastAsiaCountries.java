package Controller;

import Model.EastAsiaCountries;
import View.Utils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ManageEastAsiaCountries {
    private ArrayList<EastAsiaCountries> list = new ArrayList<>();
    
    public void addCountryInformation(){
        for(int i = 1; i<=5; i++){
            String code = Utils.getString("Enter code of country");
            String name = Utils.getString("Enter Name of country");
            float area = Utils.getFloat("Enter total Area");
            String terrain = Utils.getString("Enter terrain of country");
            EastAsiaCountries country = new EastAsiaCountries(code,name,area,terrain);
            list.add(country);
        }
        System.out.println("Data have been add succesfully!");
    }
    
    public void displayCountry(){
        if(list.isEmpty()){
            System.out.println("No data available!!!");
        } else {
            System.out.println("Display countries you've just input");
            for(EastAsiaCountries country: list ){
                country.display();
                System.out.println();
            }
        }
    }
    public void searchCountry(){
         String searchName = Utils.getString("Enter the country name to search");

        boolean found = false;
        for (EastAsiaCountries country : list) {
            if (country.getCountryName().equalsIgnoreCase(searchName)) {
                country.display();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No country found with the entered name.");
        }
    }
    
    public void sortCountries(){
        if(list.isEmpty()){
            System.out.println("No data available!!!");
            return;
        }
        Collections.sort(list, Comparator.comparing(EastAsiaCountries::getCountryName));
        displayCountry();
    }
}
