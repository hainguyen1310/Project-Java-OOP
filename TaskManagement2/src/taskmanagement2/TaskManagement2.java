package taskmanagement2;

import Controller.TaskController;
import Model.Task;
import View.Menu;
import java.util.ArrayList;

public class TaskManagement2 extends Menu {
    private final ArrayList<Task> lt;
    private int id;
    private final TaskController tc;
    private static final String[] mc = {"Add Task","Delete Task","Display","Exit"};

    public TaskManagement2() {
        super("\n========Task Program========",mc);
        this.tc = new TaskController();
        this.lt = new ArrayList<>();
        this.id = 1;
    }

    public static void main(String[] args) {
        new TaskManagement2().run();
    }
    
    @Override
    public void execute(int n ){
        switch (n){
            case 1:
                tc.addTask(lt, id);
                id++;
                break;
            case 2:
                tc.deleteTask(lt, id);
                id--;
                break;
            case 3:
                tc.print(lt);
                break;
            default:
                System.exit(0);
        }
    }
}
