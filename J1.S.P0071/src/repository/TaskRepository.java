package repository;

import constants.Constants;
import dto.TaskRequestDTO;
import dto.TaskResponseDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import model.Task;

public class TaskRepository {

    // Dung TreeMap de tu dong sap xep theo ID tang dan
    private TreeMap<Integer, Task> taskMap = new TreeMap<>();
    // Auto increment ID
    private int currentId = 1;

    public TaskRepository() {
    }

    // Them task tu RequestDTO, tra ve id task
    public int addTask(TaskRequestDTO requestDTO) {
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
        return currentId++;
    }

    // Xoa task theo id
    public void deleteTask(int id) {
        taskMap.remove(id);
    }

    // Lay tat ca task dang ResponseDTO, da sap xep theo ID tang dan
    public List<TaskResponseDTO> getDataTasks() {
        List<TaskResponseDTO> result = new ArrayList<>();
        for (Task task : taskMap.values()) {
            result.add(new TaskResponseDTO(
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

    // Kiem tra task co ton tai khong
    public boolean isExistTask(int id) {
        return taskMap.containsKey(id);
    }

    // Kiem tra database co rong khong
    public boolean isEmpty() {
        return taskMap.isEmpty();
    }
}
