package View;

import Controller.ExpenseController;
import Library.Validation;
import Model.Expense;
import java.util.ArrayList;

public class ExpenseView extends Menu{
    private static String[] mc = {"Add Expense","Delete Expense", "Display Expense","Exit"};
    private ExpenseController ec;
    private Validation va = new Validation();
    private int id = 1;

    public ExpenseView() {
        super("\n=======Handy Expense program======", mc);
    }
    public ExpenseView(Validation va, ExpenseController ec) {
        this.va = va;
        this.ec = ec;
    }
    public ExpenseController getEc() {
        return ec;
    }

    public void setEc(ExpenseController ec) {
        this.ec = ec;
    }
    
    @Override
    public void execute(int n) {
        switch(n){
            case 1:
                addExpense(id);
                id++;
                break;
            case 2:
                deleteExpense(id);
                id--;
                break;
            case 3:
                print();
                break;
            default:
                System.exit(0);
        }
    }
    
    public void addExpense(int id){
        System.out.println("-------- Add an expense--------");
        System.out.println("Enter Date:");
        String date = va.checkInputString();
        System.out.println("Enter Amount:");
        double number = va.checkInputDouble();
        System.out.println("Enter Content:");
        String content = va.checkInputString();
        ec.addExpense(id,date,number,content);
        System.out.println("Add Expense Success!!");
    }
    
    public void deleteExpense(int id){
        System.out.println("--------Delete an expense------");
        ec.deleteExpense();
    }
    
    public int findExpense(ArrayList<Expense> le) {
        System.out.print("Enter id: ");
        int id = va.checkInputInt();
        for (int i = 0; i < le.size(); i++) {
            if (le.get(i).getId() == id) {
                return i;
            }
        }
        System.err.println("Not found.");
        return -1;
    }
    
    public void print(){
        System.out.println("----------------- Display All Expense -----------------");
        System.out.printf("%-5s%-15s%-15s%-15s\n",
                "ID", "Date", "Amount", "Content");
        ec.print();
    }
}
