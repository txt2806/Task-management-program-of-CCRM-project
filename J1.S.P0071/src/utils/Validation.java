/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import constants.Message;
import java.text.SimpleDateFormat;

public final class Validation {

    //private constructor
    private Validation() {
    }

    //ham nhap chuoi va validate
    public static String getString(String input) throws Exception {
        if (input == null || input.isEmpty()) {
            throw new Exception(Message.EMPTY_INPUT);
        }
        return input.trim();
    }

    //Ham lay so nguyen duong
    public static int getPositiveInteger(String input) throws Exception {
        try {
            int number = Integer.parseInt(input.trim());
            //kiem tra xem so co > 0 hay k
            if (number <= 0) {
                throw new Exception(Message.POSITIVE_NUMBER);
            }
            return number;
        } catch (NumberFormatException e) {
            //thong bao loi
            throw new Exception(Message.INVALID_NUMBER);
        }
    }

    //Ham lay so thuc duong
    public static double getPositiveDouble(String input) throws Exception {
        try {
            double number = Double.parseDouble(input.trim());
            if (number <= 0) {
                throw new Exception(Message.POSITIVE_NUMBER);
            }
            return number;
        } catch (NumberFormatException e) {
            throw new Exception(Message.INVALID_NUMBER);
        }
    }

    //Ham validate choice
    public static int getChoice(String input, int min, int max) throws Exception {
        try {
            int choice = Integer.parseInt(input.trim());
            if ((choice < min) || (choice > max)) {
                throw new Exception(String.format(Message.INVALID_RANGE, min, max));
            }
            return choice;
        } catch (NumberFormatException e) {
            //thong bao loi
            throw new Exception(Message.INVALID_NUMBER);
        }
    }

    //Ham validate date format dd-MM-yyyy
    public static String getValidDate(String input) throws Exception {
        if (input == null || input.trim().isEmpty()) {
            throw new Exception(Message.EMPTY_INPUT);
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

    //Ham validate time (8.0 - 17.5, step 0.5)
    public static double getValidTime(String input) throws Exception {
        try {
            double time = Double.parseDouble(input.trim());
            if (time < 8.0 || time > 17.5 || (time * 10) % 5 != 0) {
                throw new Exception(Message.INVALID_TIME);
            }
            return time;
        } catch (NumberFormatException e) {
            throw new Exception(Message.INVALID_NUMBER);
        }
    }

    //Ham validate task type (1-4)
    public static int getTaskType(String input) throws Exception {
        try {
            int type = Integer.parseInt(input.trim());
            if (type < 1 || type > 4) {
                throw new Exception(Message.INVALID_TASK_TYPE);
            }
            return type;
        } catch (NumberFormatException e) {
            throw new Exception(Message.INVALID_NUMBER);
        }
    }
}
