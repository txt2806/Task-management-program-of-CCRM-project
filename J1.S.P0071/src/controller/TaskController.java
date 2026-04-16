/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import constants.Message;
import dto.TaskRequestDTO;
import dto.TaskResponseDTO;
import java.util.Map;
import repository.TaskRepository;
import view.TaskView;

/**
 *
 * @author thanh
 */
public class TaskController {

    private TaskRepository taskRepository;
    private TaskView taskView;

    //constructor co chua view va repository
    public TaskController() {
        taskRepository = new TaskRepository();
        taskView = new TaskView();
    }

    //Function 1: Add Task
    public void addTask(TaskRequestDTO requestDTO) throws Exception {
        taskRepository.addTask(requestDTO);
    }

    //Function 2: Delete Task
    public void deleteTask(int id) throws Exception {
        //Kiem tra xem co ton tai hay k
        if (!taskRepository.isExistTask(id)) {
            throw new Exception(Message.NO_TASK_AVAILABLE);
        }
        taskRepository.deleteTask(id);
    }

    //Function 3: Display all tasks
    public void displayTasks() throws Exception {
        //Kiem tra database co du lieu truoc khi display
        if (taskRepository.isEmpty()) {
            throw new Exception(Message.DATABASE_EMPTY);
        }
        //Lay tat ca task
        Map<Integer, TaskResponseDTO> result = taskRepository.getAllTasks();
        //Truyen du lieu sang view
        taskView.setTaskMap(result);
        taskView.display();
    }
}
