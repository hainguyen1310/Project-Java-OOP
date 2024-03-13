package household.waste;

import View.GarbageView;
import java.util.Scanner;

public class HouseholdWaste {

    public static void main(String[] args) {
        GarbageView view = new GarbageView();
        String choice;
        Scanner sc = new Scanner(System.in);
        do {
            view.menu();
            System.out.println("\nDo you want to continue? (Y/N)");
            choice = sc.nextLine();
        } while ("y".equals(choice) || "Y".equals(choice));
    }
}
