package Model;

import java.util.ArrayList;
import java.util.List;

public class EquationModel {
    private float number;

    public EquationModel() {
    }

    public EquationModel(float number) {
        this.number = number;
    }
    

    public List<Float> calculateEquation(float a, float b) {
        List<Float> solutions = new ArrayList<>();
        if(a==0 && b==0){
            return new ArrayList<>();
        }
        if(a==0 && b!=0){
            return null;
        }
        float ans = -b/a;
        solutions.add(ans);
        return solutions;
    }

    public List<Float> calculateQuadraticEquation(float a, float b, float c) {
        List<Float> solutions = new ArrayList<>();

        float delta = b * b - 4 * a * c;

        if (delta > 0) {
            float x1 = (-b + (float) Math.sqrt(delta)) / (2 * a);
            float x2 = (-b - (float) Math.sqrt(delta)) / (2 * a);
            solutions.add(x1);
            solutions.add(x2);
        } else if (delta == 0) {
            float x = -b / (2 * a);
            solutions.add(x);
        } else {
            return null;
        }

        return solutions;
    }

    public static boolean isOdd(float number) {
        return (number % 2 != 0);
    }

    public static boolean isEven(float number) {
        return (number % 2 == 0);
    }

    public static boolean isPerfectSquare(float number) {
        double sqrt = Math.sqrt(number);
        return (sqrt - Math.floor(sqrt)) == 0;
    }
}

