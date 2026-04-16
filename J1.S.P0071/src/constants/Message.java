/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constants;

public final class Message {

    //private Constructor
    private Message() {
    }

    //message menu
    public static final String MENU
            = "                     MENU\n"
            + "\n===============================================================\n"
            + "1. Add Task.\n"
            + "2. Delete Task.\n"
            + "3. Display Task.\n"
            + "4. Exit.\n"
            + "===============================================================";

    //thong bao nhap
    public static final String INPUT_ID = "Enter ID of task: ";
    public static final String INPUT_NAME = "Enter requirement name: ";
    public static final String INPUT_TASK_TYPE = "Enter Task Type ID (1: Code | 2: Test | 3: Design | 4: Review): ";
    public static final String INPUT_DATE = "Enter date (dd-MM-yyyy): ";
    public static final String INPUT_PLAN_FROM = "Enter plan from (8.0 - 17.5): ";
    public static final String INPUT_PLAN_TO = "Enter plan to (8.0 - 17.5): ";
    public static final String INPUT_ASSIGNEE = "Enter assignee: ";
    public static final String INPUT_REVIEWER = "Enter reviewer: ";
    public static final String INPUT_CHOICE = "Enter your choice";

    //thong bao loi
    public static final String EMPTY_INPUT = "Input must not be empty";
    public static final String INVALID_NUMBER = "The number input is invalid";
    public static final String DUPLICATE = "The task ID has already exist in database.";
    public static final String POSITIVE_NUMBER = "Please input positive number";
    public static final String INVALID_RANGE = "The input range is not valid. Please enter in range %d - %d";
    public static final String INVALID_CHOICE = "Please input choice again";
    public static final String NO_TASK_AVAILABLE = "The task doesn't exist in database";
    public static final String INVALID_DATE = "Invalid date format. Please enter date in format dd-MM-yyyy";
    public static final String INVALID_TIME = "Invalid time. Please enter time from 8.0 to 17.5 (step 0.5)";
    public static final String INVALID_TIME_RANGE = "Plan from must be less than plan to";
    public static final String INVALID_TASK_TYPE = "Task type must be in range 1 - 4";
    public static String DATABASE_EMPTY = "Database is empty";

    //thong bao thanh cong
    public static final String ADD_SUCCESS = "Task added successfully!";
    public static final String DELETE_SUCCESS = "Task deleted successfully!";
}
