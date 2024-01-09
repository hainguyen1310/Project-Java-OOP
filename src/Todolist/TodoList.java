package Todolist;

import java.util.Scanner;

class Task {
    String description;
    boolean completed;
    Task next;

    public Task(String description) {
        this.description = description;
        this.completed = false;
        this.next = null;
    }
}

public class TodoList {
    private Task head;

    public TodoList() {
        this.head = null;
    }

    public void addTask(String description) {
        Task newTask = new Task(description);
        if (head == null) {
            head = newTask;
        } else {
            Task current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newTask;
        }
        System.out.println("Task added: " + description);
    }

    public void markTaskAsCompleted(String description) {
        Task current = head;
        while (current != null) {
            if (current.description.equals(description)) {
                current.completed = true;
                System.out.println("Task marked as completed: " + description);
                return;
            }
            current = current.next;
        }
        System.out.println("Task not found: " + description);
    }

    public void removeTask(String description) {
        if (head == null) {
            System.out.println("Task not found: " + description);
            return;
        }

        if (head.description.equals(description)) {
            head = head.next;
            System.out.println("Task removed: " + description);
            return;
        }

        Task current = head;
        while (current.next != null && !current.next.description.equals(description)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
            System.out.println("Task removed: " + description);
        } else {
            System.out.println("Task not found: " + description);
        }
    }

    public void displayTasks() {
        if (head == null) {
            System.out.println("No tasks in the to-do list.");
        } else {
            System.out.println("To-Do List:");
            Task current = head;
            while (current != null) {
                System.out.println((current.completed ? "[X]" : "[ ]") + " " + current.description);
                current = current.next;
            }
        }
    }
}

class TodoListApplication {
    public static void main(String[] args) {
        TodoList todoList = new TodoList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- To-Do List Application ---");
            System.out.println("1. Add Task");
            System.out.println("2. Mark Task as Completed");
            System.out.println("3. Remove Task");
            System.out.println("4. Display Tasks");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    todoList.addTask(description);
                    break;

                case 2:
                    System.out.print("Enter task description to mark as completed: ");
                    description = scanner.nextLine();
                    todoList.markTaskAsCompleted(description);
                    break;

                case 3:
                    System.out.print("Enter task description to remove: ");
                    description = scanner.nextLine();
                    todoList.removeTask(description);
                    break;

                case 4:
                    todoList.displayTasks();
                    break;

                case 5:
                    System.out.println("Exiting the application. Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
