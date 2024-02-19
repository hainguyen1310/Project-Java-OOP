package Controller;

import Model.HistorySalary;
import java.util.ArrayList;

public class HistorySalaryController {
    private ArrayList<HistorySalary> salaryHistories = new ArrayList<>();

    // Function to adjust salary
    public void changeSalary(String workerId, double amount, String status) throws Exception {
        // Validation logic here

        HistorySalary Historysalary = new HistorySalary(workerId, amount, status);
        salaryHistories.add(Historysalary);
    }

    // Function to get information about adjusted salaries
    public ArrayList<HistorySalary> getInfomationSalary() {
        // Sort salary histories by worker id
        salaryHistories.sort((s1, s2) -> s1.getWorkerCode().compareTo(s2.getWorkerCode()));
        return salaryHistories;
    }
}
