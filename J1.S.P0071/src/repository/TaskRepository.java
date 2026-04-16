/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import constants.Constants;
import dto.TaskRequestDTO;
import dto.TaskResponseDTO;
import java.util.HashMap;
import java.util.Map;
import model.Task;

/**
 *
 * @author thanh
 */
public class TaskRepository {

    //Danh sach task
    private Map<Integer, Task> taskMap = new HashMap<>();
    //Auto increment ID
    private int currentId = 1;

    //constructor
    public TaskRepository() {
    }

    //add task
    public boolean addTask(TaskRequestDTO requestDTO) {
        Task task = new Task(
                currentId,
                requestDTO.getTaskTypeId(),
                requestDTO.getRequirementName(),
                requestDTO.getDate(),
                requestDTO.getPlanFrom(),
                requestDTO.getPlanTo(),
                requestDTO.getAssignee(),
                requestDTO.getReviewer()
        );
        taskMap.put(currentId, task);
        currentId++;
        return true;
    }

    //delete task
    public boolean deleteTask(int id) {
        taskMap.remove(id);
        return true;
    }

    //get all tasks -> tra ve Map<Integer, TaskResponseDTO>
    public Map<Integer, TaskResponseDTO> getAllTasks() {
        Map<Integer, TaskResponseDTO> result = new HashMap<>();

        for (Task task : taskMap.values()) {
            result.put(task.getId(), new TaskResponseDTO(
                    task.getId(),
                    task.getRequirementName(),
                    Constants.getTaskTypeName(task.getTaskTypeId()),
                    task.getDate(),
                    task.getPlanFrom(),
                    task.getPlanTo(),
                    task.getAssignee(),
                    task.getReviewer()
            ));
        }
        return result;
    }

    //kiem tra xem co ton tai task hay k
    public boolean isExistTask(int id) {
        return taskMap.containsKey(id);
    }

    //kiem tra xem co rong k
    public boolean isEmpty() {
        return taskMap.isEmpty();
    }
}
