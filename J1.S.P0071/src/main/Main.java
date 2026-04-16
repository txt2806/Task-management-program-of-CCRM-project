/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import constants.Message;
import controller.TaskController;
import dto.TaskRequestDTO;
import java.util.Scanner;
import utils.Validation;

/**
 *
 * @author thanh
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskController controller = new TaskController();
        while (true) {
            //Hien thi menu
            System.out.println(Message.MENU);
            //Hien thi lua chon
            System.out.println(Message.INPUT_CHOICE);
            try {
                int choice = Validation.getChoice(sc.nextLine(), 1, 4);
                switch (choice) {

                    //add task
                    case 1:
                        // tao dto de nhap du lieu
                        TaskRequestDTO dto = new TaskRequestDTO();

                        //nhap requirement name
                        System.out.print(Message.INPUT_NAME);
                        dto.setRequirementName(Validation.getString(sc.nextLine()));

                        //nhap task type
                        System.out.print(Message.INPUT_TASK_TYPE);
                        dto.setTaskTypeId(Validation.getTaskType(sc.nextLine()));

                        //nhap date
                        System.out.print(Message.INPUT_DATE);
                        dto.setDate(Validation.getValidDate(sc.nextLine()));

                        //nhap plan from
                        System.out.print(Message.INPUT_PLAN_FROM);
                        double planFrom = Validation.getValidTime(sc.nextLine());
                        dto.setPlanFrom(planFrom);

                        //nhap plan to
                        System.out.print(Message.INPUT_PLAN_TO);
                        double planTo = Validation.getValidTime(sc.nextLine());
                        //kiem tra plan from < plan to
                        if (planFrom >= planTo) {
                            throw new Exception(Message.INVALID_TIME_RANGE);
                        }
                        dto.setPlanTo(planTo);

                        //nhap assignee
                        System.out.print(Message.INPUT_ASSIGNEE);
                        dto.setAssignee(Validation.getString(sc.nextLine()));

                        //nhap reviewer
                        System.out.print(Message.INPUT_REVIEWER);
                        dto.setReviewer(Validation.getString(sc.nextLine()));

                        controller.addTask(dto);
                        System.out.println(Message.ADD_SUCCESS);
                        break;

                    //delete task
                    case 2:
                        //nhap id can xoa
                        System.out.print(Message.INPUT_ID);
                        int deleteId = Validation.getPositiveInteger(sc.nextLine());
                        controller.deleteTask(deleteId);
                        System.out.println(Message.DELETE_SUCCESS);
                        break;

                    //display tasks
                    case 3:
                        controller.displayTasks();
                        break;

                    //Thoat chuong trinh
                    case 4:
                        return;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
