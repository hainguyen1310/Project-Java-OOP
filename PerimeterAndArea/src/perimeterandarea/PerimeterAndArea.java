package perimeterandarea;

import Controller.PerimeterAndAreaController;
import Model.Circle;
import Model.Rectangle;
import Model.Triangle;
import View.Menu;
import java.util.Scanner;

public class PerimeterAndArea extends PerimeterAndAreaController {   

  public static void main(String[] args) {
        Rectangle rectangle = inputRectangle();
        Circle circle = inputCircle();
        Triangle trigle = inputTriangle();

        display(trigle, rectangle, circle);
    }

   
}