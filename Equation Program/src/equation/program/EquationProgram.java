package equation.program;

import Model.EquationModel;
import View_Controller.Menu;
import View_Controller.Utils;
import java.util.List;

public class EquationProgram extends Menu {
    private EquationModel em;
    private static String[] mc = {"Calculate Superlative Equation", "Calculate Quadratic Equation", "Exit"};

    public EquationProgram() {
        super("\nEquation Program",mc);
        this.em = new EquationModel();
    }
    
    public static void main(String[] args) {
        new EquationProgram().run();
    }
    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                float a1 =  Utils.getFloat("Enter coefficient A");
                float b1 =  Utils.getFloat("Enter coefficient B");
                List<Float> solution1 = em.calculateEquation(a1, b1);
                Utils.displayResults(solution1, a1,b1);
                break;
            case 2:
                float a2 =  Utils.getFloat("Enter coefficient A");
                float b2 =  Utils.getFloat("Enter coefficient B");
                float c2 =  Utils.getFloat("Enter coefficient C");
                List<Float> solution2 = em.calculateQuadraticEquation(a2, b2, c2);
                Utils.displayResults(solution2, a2,b2,c2);
                break;
            default:
                System.out.println("See you again, Goodbye!!!");
                System.exit(0);
                break;
        }
    }
}
