package controller;

import constants.Message;
import dto.TaskRequestDTO;
import dto.TaskResponseDTO;
import java.util.List;
import repository.TaskRepository;
import utils.Validation;

public class TaskController {

    private TaskRepository taskRepository;

    public TaskController() {
        taskRepository = new TaskRepository();
    }

    /**
     * Add task - nhan tat ca tham so la String, dung Validation de validate.
     * Tra ve id cua task vua them.
     */
    public int addTask(String requirementName, String assignee,
            String reviewer, String taskTypeID, String date,
            String planFrom, String planTo) throws Exception {

        // Validate bang Validation utility
        String validName = Validation.getString(requirementName);
        String validAssignee = Validation.getString(assignee);
        String validReviewer = Validation.getString(reviewer);
        int validTypeId = Validation.getTaskType(taskTypeID);
        String validDate = Validation.getValidDate(date);
        double validFrom = Validation.getValidTime(planFrom);
        double validTo = Validation.getValidTime(planTo);

        // Kiem tra plan from < plan to
        if (validFrom >= validTo) {
            throw new Exception(Message.INVALID_TIME_RANGE);
        }

        // Tao RequestDTO tu du lieu da validate
        TaskRequestDTO requestDTO = new TaskRequestDTO();
        requestDTO.setRequirementName(validName);
        requestDTO.setTaskTypeId(validTypeId);
        requestDTO.setDate(validDate);
        requestDTO.setPlanFrom(validFrom);
        requestDTO.setPlanTo(validTo);
        requestDTO.setAssignee(validAssignee);
        requestDTO.setReviewer(validReviewer);

        return taskRepository.addTask(requestDTO);
    }

    /**
     * Delete task - nhan id la String, validate bang Validation.
     */
    public void deleteTask(String id) throws Exception {
        int taskId = Validation.getPositiveInteger(id);

        if (!taskRepository.isExistTask(taskId)) {
            throw new Exception(Message.NO_TASK_AVAILABLE);
        }

        taskRepository.deleteTask(taskId);
    }

    /**
     * Lay danh sach tat ca task dang ResponseDTO, da sap xep theo ID tang dan.
     */
    public List<TaskResponseDTO> getDataTasks() throws Exception {
        if (taskRepository.isEmpty()) {
            throw new Exception(Message.DATABASE_EMPTY);
        }
        return taskRepository.getDataTasks();
    }
}
