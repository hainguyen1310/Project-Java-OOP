package worker.management;

import Controller.WorkerManagement;
import View.Menu;

public class WorkerManagementApp extends Menu{
    private WorkerManagement wm;
    private static String[] mc = {"Add a Worker", "Up Salary","Down Salary","Display Information salary", "Exit"};

    public WorkerManagementApp() {
        super("\nWorker Program", mc);
        this.wm = new WorkerManagement();
    }
    
    public static void main(String[] args) {
        new WorkerManagementApp().run();
    }
    
    @Override
        public void execute(int n) {
            try{
                switch (n) {
                case 1:
                    wm.addWorker();
                    break;
                case 2:
                    wm.changeSalary("increase");
                    break;
                case 3:
                    wm.changeSalary("decreased");
                    break;
                case 4:
                    wm.showAdjustedSalaryInformation();
                    break;
                default:
                    System.out.println("See you again. Goodbye!!!");
                    System.exit(0);
                    break;
                } 
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
}
