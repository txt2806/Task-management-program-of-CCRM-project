/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dto.TaskResponseDTO;
import java.util.Map;

/**
 *
 * @author thanh
 */
public class TaskView {

    private Map<Integer, TaskResponseDTO> taskMap;

    //set de chinh sua thong tin
    public void setTaskMap(Map<Integer, TaskResponseDTO> taskMap) {
        this.taskMap = taskMap;
    }

    //Hien thi thong tin
    public void display() {
        // Hien thi header
        System.out.println("\n------------------------------------- TASK -------------------------------------");
        System.out.printf("%-5s %-20s %-10s %-12s %-7s %-7s %-12s %-12s\n",
                "ID", "Name", "Type", "Date", "From", "To", "Assignee", "Reviewer");
        System.out.println("--------------------------------------------------------------------------------");
        // Duyet qua danh sach va hien thi tung thong tin
        for (TaskResponseDTO task : taskMap.values()) {
            System.out.println(task);
        }
        System.out.println("--------------------------------------------------------------------------------");
    }
}
