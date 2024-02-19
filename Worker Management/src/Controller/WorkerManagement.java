package Controller;

import Model.HistorySalary;
import Model.Worker;
import View.Utils;
import java.util.ArrayList;

public class WorkerManagement {
    private WorkerController workerController = new WorkerController();
    private HistorySalaryController historySalaryController = new HistorySalaryController();
    
    public void addWorker() throws Exception {
        String code = Utils.getString("Enter worker code");
        if (code == null || workerController.getWorkerByCode(code) != null) {
            throw new Exception("Invalid code. Please enter a unique code.");
        }

        String name = Utils.getString("Enter worker name");

        int age = Utils.getInt("Enter worker age");

        if (age < 18 || age > 50) {
            throw new Exception("Invalid age. Age must be between 18 and 50.");
        }
        
        double salary = Utils.getDouble("Enter worker salary");

        if (salary <= 0) {
            throw new Exception("Invalid salary. Salary must be greater than 0.");
        }

        String workLocation = Utils.getString("Enter worker work location");
        workerController.addWorker(code, name, age, salary, workLocation);

        System.out.println("Worker added successfully!");
    }

    public void changeSalary(String status) throws Exception {
        String code = Utils.getString("Enter worker code");

        Worker worker = workerController.getWorkerByCode(code);
        if (worker == null) {
            throw new Exception("Invalid worker id. Worker not found.");
        }
        
        double amount = Utils.getDouble("Enter amount of money to " + (status.equals("increase") ? "raise" : "cut") + "");

        if (amount <= 0) {
            throw new Exception("Invalid amount. Amount must be greater than 0.");
        }
        historySalaryController.changeSalary(code, amount, status);

        System.out.println("Salary " + (status.equals("increase") ? "increased" : "decreased") + " successfully!");
    }

    public void showAdjustedSalaryInformation() {
        ArrayList<HistorySalary> sortedSalaryHistories = historySalaryController.getInfomationSalary();
        System.out.println("--------------- Display Information Salary ---------------");
        System.out.printf("%-5s%-10s%-15s%-10s%-10s%n", "Code", "Name", "Age", "Salary", "Status");
        
        for (HistorySalary salaryHistory : sortedSalaryHistories) {
            Worker worker = workerController.getWorkerByCode(salaryHistory.getWorkerCode());
            System.out.printf("%-4s%-12s%-17d%-12.2f%-10s%n",
                    worker.getCode(), worker.getName(), worker.getAge(), worker.getSalary(),
                    salaryHistory.getStatus().equals("increase") ? "UP" : "DOWN");
        }
    }
}
