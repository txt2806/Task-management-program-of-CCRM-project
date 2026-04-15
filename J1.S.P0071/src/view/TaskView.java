package view;

import model.dto.TaskDTO;
import java.util.List;

public class TaskView {

    public static void menu() {
        System.out.println("\n========= Task program =========");
        System.out.println("1. Add Task");
        System.out.println("2. Delete Task");
        System.out.println("3. Display Task");
        System.out.println("4. Exit");
    }

    public static void display(List<TaskDTO> list) {

        System.out.println("\n------------------------------------- TASK -------------------------------------");

        // Header
        System.out.printf("%-5s %-20s %-10s %-12s %-15s %-12s %-12s\n",
                "ID", "Name", "Type", "Date", "Time", "Assignee", "Reviewer");

        System.out.println("--------------------------------------------------------------------------------");

        // Data
        for (TaskDTO t : list) {
            System.out.printf("%-5d %-20s %-10s %-12s %-15s %-12s %-12s\n",
                    t.getId(),
                    t.getName(),
                    t.getType(),
                    t.getDate(),
                    t.getTime(),
                    t.getAssignee(),
                    t.getReviewer());
        }

        System.out.println("--------------------------------------------------------------------------------");
    }
}
