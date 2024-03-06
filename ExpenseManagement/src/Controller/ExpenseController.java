package Controller;

import Library.Validation;
import Model.Expense;
import View.ExpenseView;
import java.util.ArrayList;

public class ExpenseController {
    private ExpenseView view;
    private Expense model;
    private Validation va;
    private ArrayList<Expense> le;

    public ExpenseController(ExpenseView view, Expense model) {
        this.view = view;
        this.model = model;
        this.le = new ArrayList<>();
    }
    
    public void run(){
        view.setEc(this);
        view.run();
    }
    
    public void addExpense(int id, String date, double number, String content){
        le.add(new Expense(id,number,date,content));
    }
    
    public void deleteExpense(){
        if (le.isEmpty()) {
            System.err.println("List empty");
        }
        int findId = view.findExpense(le);
        if (findId != -1) {
            le.remove(findId);
            for (int i = findId; i < le.size(); i++) {
                le.get(i).setId(le.get(i).getId() - 1);
            }
        }
        System.out.println("Delete success.");
    }
    
    public void print(){
        if (le.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        for (int i = 0; i < le.size(); i++) {
            System.out.printf("%-5d%-15s%-15s%-15s\n",
                    le.get(i).getId(),
                    le.get(i).getDate(),
                    le.get(i).getNumber(),
                    le.get(i).getContent()
            );
        }
        
        double totalAmount = calculateTotalAmount();
        System.out.println("Total: " + totalAmount);
    }
    
    public double calculateTotalAmount() {
        double totalAmount = 0;
        for (Expense expense : le) {
            totalAmount += expense.getNumber();
        }
        return totalAmount;
    }

}
