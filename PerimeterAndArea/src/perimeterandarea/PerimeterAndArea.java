package perimeterandarea;

import Controller.PerimeterAndAreaController;
import Model.Circle;
import Model.Rectangle;
import Model.Triangle;
import View.Menu;

public class PerimeterAndArea extends Menu {
    private PerimeterAndAreaController pc;
    private static String[] mc = {"Circle", "Rectangle","Triangle", "Exit"};

    public PerimeterAndArea() {
        super("\nCalculator Program", mc);
        this.pc = new PerimeterAndAreaController();
    }

    public static void main(String[] args) {
        new PerimeterAndArea().run();
    }

    @Override
    public void execute(int n) {
        switch (n) {
                case 1:
                    pc.calculateCircle();
                    break;
                case 2:
                    pc.calculateRectangle();
                    break;
                case 3:
                    pc.calculateTriangle();
                    break;
                default:
                    System.out.println("See you again, Goodbye!!!");
                    System.exit(0);
                    break;
            }
    }
    
    
}
