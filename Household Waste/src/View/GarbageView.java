package View;

import Controller.GarbageController;
import java.util.Scanner;

public class GarbageView {

    private Scanner sc = new Scanner(System.in);

    public void menu() {
            System.out.print("Enter the number of garbage point: ");
            int n = sc.nextInt();
            int[] gLoad = new int[n];
            for (int i = 0; i < n; i++) {
                System.out.println("Enter Station " + (i+1) + ":");
                gLoad[i] = sc.nextInt();
            }
            GarbageController GarbageController = new GarbageController(gLoad);
            GarbageController.start();    
    }
}
