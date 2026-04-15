package model.service;

import model.entity.Task;
import model.dto.TaskDTO;
import model.repository.ITaskRepository;
import util.ValidationUtil;

import java.util.*;

public class TaskService {

    private ITaskRepository repo;
    private int currentId = 1;

    public TaskService(ITaskRepository repo) {
        this.repo = repo;
    }

    public int addTask(String name, String assignee, String reviewer,
            String taskTypeID, String date,
            String from, String to) throws Exception {
        int typeId = Integer.parseInt(taskTypeID);
        if (typeId < 1 || typeId > 4) {
            throw new Exception("Task Type must be 1-4");
        }
        if (!ValidationUtil.isValidDate(date)) {
            throw new Exception("Invalid date");
        }

        double planFrom = Double.parseDouble(from);
        double planTo = Double.parseDouble(to);
        if (!ValidationUtil.isValidTime(planFrom) || !ValidationUtil.isValidTime(planTo) || planFrom >= planTo) {
            throw new Exception("Invalid Time");
        }
        Task task = new Task(currentId++, typeId, name, date,
                planFrom, planTo, assignee, reviewer);
        return repo.add(task);

    }

    public void deleteTask(String id) throws Exception {
        repo.delete(Integer.parseInt(id));
    }


    public List<TaskDTO> getDataTasks() {
        List<TaskDTO> result = new ArrayList<>();

        for (Task t : repo.findAll()) {
            String typeName = getTypeName(t.getTaskTypeId());

            TaskDTO dto = new TaskDTO(
                    t.getId(),
                    t.getRequirementName(),
                    typeName,
                    t.getDate(),
                    t.getPlanFrom() + "-" + t.getPlanTo(),
                    t.getAssignee(),
                    t.getReviewer()
            );

            result.add(dto);
        }

        return result;
    }

    private String getTypeName(int id) {
        switch (id) {
            case 1:
                return "Code";
            case 2:
                return "Test";
            case 3:
                return "Design";
            case 4:
                return "Review";
            default:
                return "Unknown";
        }
    }

}
