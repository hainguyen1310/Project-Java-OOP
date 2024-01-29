package ComputerProgram;

import Controller.Calculator;
import View.Menu;
import View.Utils;

public class ComputerProgram extends Menu {
    private Calculator c;
    private static String[] mc = {"Normal Caculator", "BMI Caculator", "Exit"};

    public ComputerProgram() {
        super("\nComputer Program",mc);
        this.c = new Calculator();
    }
    
    public static void main(String[] args) {
        new ComputerProgram().run();
    }
    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                c.runNormalCalculator();
                break;
            case 2:
                c.runBMICalculator();
                break;
            default:
                System.out.println("See you again, Goodbye!!!");
                System.exit(0);
                break;
        }
    }
}

