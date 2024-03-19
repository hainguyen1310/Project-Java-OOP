package Model;

public class TaxCalculator {
    private static final int EXEMPTION_LIMIT = 11000000;
    private static final int TAX_RATE_1 = 5;
    private static final int TAX_RATE_2 = 10;
    private static final int TAX_RATE_3 = 20;
    private static final int STUDENT_CHILD_DEDUCTION = 6000000;
    private static final int NON_STUDENT_CHILD_DEDUCTION = 4400000;
    private static final int PARENT_DEDUCTION = 4400000;

    public static double calculateTax(double totalIncome, int numberOfChildren, boolean[] childrenOver18,
                                       int numberOfParents, boolean[] parentsOver60) {
        double taxableIncome = totalIncome - calculateDeductions(numberOfChildren, childrenOver18, numberOfParents, parentsOver60);
        if (taxableIncome <= EXEMPTION_LIMIT) {
            return 0;
        } else if (taxableIncome <= 6000000) {
            return taxableIncome * TAX_RATE_1 / 100;
        } else if (taxableIncome <= 10000000) {
            return 6000000 * TAX_RATE_1 / 100 + (taxableIncome - 6000000) * TAX_RATE_2 / 100;
        } else {
            return 6000000 * TAX_RATE_1 / 100 + 4000000 * TAX_RATE_2 / 100 + (taxableIncome - 10000000) * TAX_RATE_3 / 100;
        }
    }

    private static double calculateDeductions(int numberOfChildren, boolean[] childrenOver18, int numberOfParents, boolean[] parentsOver60) {
        double deduction = 11000000; // Deduction for self
        int childDeductionCount = Math.min(numberOfChildren, 2);
        for (int i = 0; i < childDeductionCount; i++) {
            if (childrenOver18[i]) {
                deduction += STUDENT_CHILD_DEDUCTION;
            } else {
                deduction += NON_STUDENT_CHILD_DEDUCTION;
            }
        }

        int parentDeductionCount = 0;
        for (boolean parent : parentsOver60) {
            if (parent) {
                parentDeductionCount++;
            }
        }
        if (parentDeductionCount > 0) {
            deduction += parentDeductionCount * PARENT_DEDUCTION / numberOfParents;
        }

        return deduction;
    }
}
