package Model;

public class HistorySalary {
    private String workerCode;
    private double amount;
    private String status;

    public String getWorkerCode() {
        return workerCode;
    }

    public void setWorkerCode(String workerCode) {
        this.workerCode = workerCode;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public HistorySalary(String workerCode, double amount, String status) {
        this.workerCode = workerCode;
        this.amount = amount;
        this.status = status;
    }
    
    @Override
    public String toString() {
        return "SalaryHistory{workerId='" + workerCode + "', amount=" + amount + "', status='" + status + "'}";
    }
}
