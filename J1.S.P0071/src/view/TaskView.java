package view;

import dto.TaskResponseDTO;
import java.util.List;

public class TaskView {

    // Hien thi danh sach task
    public void display(List<TaskResponseDTO> tasks) {
        System.out.println("\n------------------------------------- TASK -------------------------------------");
        System.out.printf("%-5s %-20s %-10s %-12s %-7s %-7s %-12s %-12s%n",
                "ID", "Name", "Type", "Date", "From", "To", "Assignee", "Reviewer");
        System.out.println("--------------------------------------------------------------------------------");
        for (TaskResponseDTO task : tasks) {
            System.out.println(task);
        }
        System.out.println("--------------------------------------------------------------------------------");
    }
}
