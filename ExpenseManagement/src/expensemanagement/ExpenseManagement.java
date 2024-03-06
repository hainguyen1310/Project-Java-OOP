package expensemanagement;

import Controller.ExpenseController;
import Model.Expense;
import View.ExpenseView;

public class ExpenseManagement {

    public static void main(String[] args) {
        Expense model = new Expense();
        ExpenseView view = new ExpenseView();
        new ExpenseController(view, model).run();
    }
    
}
