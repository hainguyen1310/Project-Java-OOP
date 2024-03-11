package View;

import static Controller.Validation.checkInputDouble;
import Model.Circle;
import Model.Rectangle;
import Model.Triangle;

public class Utils {
    public static Triangle inputTriangle() {
        while (true) {
            System.out.print("Please input side A of Triangle: ");
            double a = checkInputDouble();
            System.out.print("Please input side B of Triangle: ");
            double b = checkInputDouble();
            System.out.print("Please input side C of Triangle: ");
            double c = checkInputDouble();
            if (a + b > c && b + c > a && a + c > b) {
                return new Triangle(a, b, c);
            } else {
                System.out.println("Re-input");
            }
        }
    }

    public static Rectangle inputRectangle() {
        System.out.print("Please input side width of Rectangle: ");
        double width = checkInputDouble();
        System.out.print("Please input length of Rectangle: ");
        double length = checkInputDouble();
        return new Rectangle(width, length);
    }

    public static Circle inputCircle() {
        System.out.print("Please input radius of Circle: ");
        double radius = checkInputDouble();
        return new Circle(radius);
    }

    public static void display(Circle circle) {
        circle.printResult();
    }
    
    public static void display(Triangle triangle) {
        triangle.printResult();
    }
    
    public static void display(Rectangle rectangle) {
        rectangle.printResult();
    }
}
