package Controller;

import Library.Validation;
import Model.Task;
import View.Utils;
import java.util.ArrayList;

public class TaskController {

    public TaskController() {
    }
    
    public void addTask(ArrayList<Task> lt, int id){
        String requirementName = Utils.getString("Enter Requirement Name");
        Validation.checkInputString(requirementName);
        System.out.println("Enter Task Type (Code, Test, Manager, Learn):");
        String taskTypeId = Validation.checkInputTaskTypeId();
        String date = Utils.getString("Enter Date");
        Validation.checkInputDate(date);
        String planFrom = Utils.getString("Enter From");
        Validation.checkInputPlan(planFrom);
        String planTo = Utils.getString("Enter To");
        Validation.checkInputPlan(planTo);
        String assign = Utils.getString("Enter Assignee");
        Validation.checkInputString(assign);
        String reviewer = Utils.getString("Enter Reviewer");
        Validation.checkInputString(reviewer);
        lt.add(new Task(id, taskTypeId, requirementName, date, planFrom, planTo, assign, reviewer));
        System.out.println("Add Task Success.");
    }
    
    public void deleteTask(ArrayList<Task> lt, int id){
        if (lt.isEmpty()) {
            System.err.println("List empty");
            return;
        }
        int findId = findTask(lt);
        if (findId != -1) {
            lt.remove(findId);
            for (int i = findId; i < lt.size(); i++) {
                lt.get(i).setId(lt.get(i).getId() - 1);
            }
            System.err.println("Delete success.");
        }
    }
    
    private int findTask(ArrayList<Task> lt) {
        System.out.print("Enter id: ");
        int id = Validation.checkInputInt();
        for (int i = 0; i < lt.size(); i++) {
            if (lt.get(i).getId() == id) {
                return i;
            }
        }
        System.err.println("Not found.");
        return -1;
    }
    
    public void print(ArrayList<Task> lt){
        if (lt.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        Utils.title();
        for (int i = 0; i < lt.size(); i++) {
            System.out.printf("%-5d%-15s%-15s%-15s%-15.1f%-15s%-15s\n",
                    lt.get(i).getId(),
                    lt.get(i).getRequireName(),
                    lt.get(i).getTaskTypeId(),
                    lt.get(i).getDate(),
                    Double.parseDouble(lt.get(i).getPlanTo()) - Double.parseDouble(lt.get(i).getPlanFrom()),
                    lt.get(i).getAssign(),
                    lt.get(i).getReviewer()
            );

        }
    }
}
