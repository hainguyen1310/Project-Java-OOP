package Model;

public class CalculatorModel {
    public enum Operator {
    ADD("+"), SUBTRACT("-"), MULTIPLY("*"), DIVIDE("/"), EXPONENT("^"), EQUALS("=");

    private final String symbol;

    Operator(String symbol) {
        this.symbol = symbol;
    }

    public static Operator fromSymbol(String symbol) {
        for (Operator op : Operator.values()) {
            if (op.symbol.equals(symbol)) {
                return op;
            }
        }
        throw new IllegalArgumentException("Invalid operator symbol");
    }

    public double apply(double a, double b) {
        switch (this) {
            case ADD:
                return a + b;
            case SUBTRACT:
                return a - b;
            case MULTIPLY:
                return a * b;
            case DIVIDE:
                if (b != 0) {
                    return a / b;
                } else {
                    throw new ArithmeticException("Cannot divide by zero");
                }
            case EXPONENT:
                return Math.pow(a, b);
            case EQUALS:
                // Additional handling if needed
                return b; // Placeholder, returning the second operand for equals
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }
}

    public double calculate(double a, Operator operator, double b) {
        return operator.apply(a, b);
    }

    public enum BMI {
        UNDER_STANDARD, STANDARD, OVERWEIGHT, SHOULD_LOSE_WEIGHT, SHOULD_LOSE_WEIGHT_IMMEDIATELY
    }

    public BMI calculateBMI(double weight, double height) {
        double bmi = weight / Math.pow(height / 100, 2);

        if (bmi < 19) {
            return BMI.UNDER_STANDARD;
        } else if (bmi >= 19 && bmi <= 25) {
            return BMI.STANDARD;
        } else if (bmi > 25 && bmi <= 30) {
            return BMI.OVERWEIGHT;
        } else if (bmi > 30 && bmi <= 40) {
            return BMI.SHOULD_LOSE_WEIGHT;
        } else {
            return BMI.SHOULD_LOSE_WEIGHT_IMMEDIATELY;
        }
    }
}
