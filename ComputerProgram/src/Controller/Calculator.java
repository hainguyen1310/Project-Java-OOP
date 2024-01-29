package Controller;

import Model.CalculatorModel;
import Model.CalculatorModel.Operator;
import View.Utils;

public class Calculator{
    private CalculatorModel model;
    
    public void runNormalCalculator() {
        double result = 0.0;

    do {
        double num1 = Utils.getDouble("Enter number");
        String operatorSymbol = Utils.getOperatorSymbolInput();
        Operator operator = Operator.fromSymbol(operatorSymbol);
        double num2 = Utils.getDouble("Enter number");

        try {
            result = model.calculate(result, operator, num2);
            System.out.println("Memory: " + result);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            result = 0.0;
        }

        System.out.print("Enter Operator: ");
    } while (Utils.getOperatorSymbolInput().equals("="));

    Utils.displayResult(result);
}
    
    public void runBMICalculator() {
        double weight = Utils.getDouble("Enter your weight (kg)");
        double height = Utils.getDouble("Enter your height (cm)");

        try {
            CalculatorModel.BMI bmiStatus = model.calculateBMI(weight, height);
            Utils.displayBMIStatus(bmiStatus);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}