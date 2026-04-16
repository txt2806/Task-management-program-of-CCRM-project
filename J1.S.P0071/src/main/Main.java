package main;

import constants.Message;
import controller.TaskController;
import dto.TaskResponseDTO;
import java.util.List;
import java.util.Scanner;
import utils.Validation;
import view.TaskView;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskController controller = new TaskController();
        TaskView view = new TaskView();

        while (true) {
            // Hien thi menu
            System.out.println(Message.MENU);
            System.out.print(Message.INPUT_CHOICE);

            try {
                int choice = Validation.getChoice(sc.nextLine(), 1, 4);

                switch (choice) {
                    // Add Task
                    case 1:
                        System.out.print(Message.INPUT_TASK_TYPE);
                        String taskTypeID = sc.nextLine();

                        System.out.print(Message.INPUT_NAME);
                        String requirementName = sc.nextLine();

                        System.out.print(Message.INPUT_DATE);
                        String date = sc.nextLine();

                        System.out.print(Message.INPUT_PLAN_FROM);
                        String planFrom = sc.nextLine();

                        System.out.print(Message.INPUT_PLAN_TO);
                        String planTo = sc.nextLine();

                        System.out.print(Message.INPUT_ASSIGNEE);
                        String assignee = sc.nextLine();

                        System.out.print(Message.INPUT_REVIEWER);
                        String reviewer = sc.nextLine();

                        int newId = controller.addTask(requirementName,
                                assignee, reviewer, taskTypeID,
                                date, planFrom, planTo);

                        System.out.println(Message.ADD_SUCCESS);
                        break;

                    // Delete Task
                    case 2:
                        System.out.print(Message.INPUT_ID);
                        String deleteId = sc.nextLine();
                        controller.deleteTask(deleteId);
                        System.out.println(Message.DELETE_SUCCESS);
                        break;

                    // Display Tasks
                    case 3:
                        List<TaskResponseDTO> tasks = controller.getDataTasks();
                        view.display(tasks);
                        break;

                    // Exit
                    case 4:
                        return;
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            } catch (NullPointerException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
