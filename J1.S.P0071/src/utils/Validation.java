package utils;

import constants.Message;
import java.text.SimpleDateFormat;

public final class Validation {

    private Validation() {
    }

    // Validate chuoi khong duoc rong
    public static String getString(String input) throws Exception {
        if (input == null || input.trim().isEmpty()) {
            throw new NullPointerException(Message.EMPTY_INPUT);
        }
        return input.trim();
    }

    // Validate choice trong khoang min-max
    public static int getChoice(String input, int min, int max) throws Exception {
        try {
            int choice = Integer.parseInt(input.trim());
            if (choice < min || choice > max) {
                throw new Exception(Message.INVALID_CHOICE);
            }
            return choice;
        } catch (NumberFormatException e) {
            throw new NumberFormatException(Message.INVALID_NUMBER);
        }
    }

    // Validate so nguyen duong
    public static int getPositiveInteger(String input) throws Exception {
        try {
            int number = Integer.parseInt(input.trim());
            if (number <= 0) {
                throw new Exception(Message.INVALID_NUMBER);
            }
            return number;
        } catch (NumberFormatException e) {
            throw new NumberFormatException(Message.INVALID_NUMBER);
        }
    }

    // Validate task type (1-4)
    public static int getTaskType(String input) throws Exception {
        try {
            int type = Integer.parseInt(input.trim());
            if (type < 1 || type > 4) {
                throw new Exception(Message.INVALID_TASK_TYPE);
            }
            return type;
        } catch (NumberFormatException e) {
            throw new NumberFormatException(Message.INVALID_NUMBER);
        }
    }

    // Validate date format dd-MM-yyyy dung SimpleDateFormat
    public static String getValidDate(String input) throws Exception {
        if (input == null || input.trim().isEmpty()) {
            throw new NullPointerException(Message.EMPTY_INPUT);
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            sdf.setLenient(false);
            sdf.parse(input.trim());
            return input.trim();
        } catch (Exception e) {
            throw new Exception(Message.INVALID_DATE);
        }
    }

    // Validate time (8.0 - 17.5, step 0.5)
    public static double getValidTime(String input) throws Exception {
        try {
            double time = Double.parseDouble(input.trim());
            if (time < 8.0 || time > 17.5 || (time * 10) % 5 != 0) {
                throw new Exception(Message.INVALID_TIME);
            }
            return time;
        } catch (NumberFormatException e) {
            throw new NumberFormatException(Message.INVALID_NUMBER);
        }
    }
}
