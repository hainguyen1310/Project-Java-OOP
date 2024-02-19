package Controller;

import Model.Worker;
import java.util.HashMap;

public class WorkerController {
    private HashMap<String, Worker> workers = new HashMap<>();

    public void addWorker(String code, String name, int age, double salary, String workLocation) throws Exception {
        Worker worker = new Worker(code, name, age, salary, workLocation);
        workers.put(code, worker);
    }

    public Worker getWorkerByCode(String code) {
        return workers.get(code);
    }
}
