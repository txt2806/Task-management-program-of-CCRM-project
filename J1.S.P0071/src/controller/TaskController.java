package controller;

import model.service.TaskService;
import view.TaskView;

import java.util.Scanner;

public class TaskController {

    private TaskService service;
    private Scanner sc = new Scanner(System.in);

    public TaskController(TaskService service) {
        this.service = service;
    }

    public void run() {
        while (true) {
            TaskView.menu();
            int choice = Integer.parseInt(sc.nextLine());

            try {
                switch (choice) {
                    case 1:
                        add();
                        break;
                    case 2:
                        delete();
                        break;
                    case 3:
                        TaskView.display(service.getDataTasks());
                        break;
                    case 4:
                        return;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void add() throws Exception {
        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Type: ");
        String type = sc.nextLine();

        System.out.print("Date: ");
        String date = sc.nextLine();

        System.out.print("From: ");
        String from = sc.nextLine();

        System.out.print("To: ");
        String to = sc.nextLine();

        System.out.print("Assignee: ");
        String assignee = sc.nextLine();

        System.out.print("Reviewer: ");
        String reviewer = sc.nextLine();

        int id = service.addTask(name, assignee, reviewer, type, date, from, to);
        System.out.println("Added ID: " + id);
    }

    private void delete() throws Exception {
        System.out.print("ID: ");
        String id = sc.nextLine();
        service.deleteTask(id);
        System.out.println("Deleted!");
    }
}
