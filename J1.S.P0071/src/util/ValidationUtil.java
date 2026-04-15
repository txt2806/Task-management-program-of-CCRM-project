package util;

import java.text.SimpleDateFormat;

public class ValidationUtil {

    public static boolean isValidDate(String date) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            sdf.setLenient(false);
            sdf.parse(date);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isValidTime(double t) {
        return t >= 8.0 && t <= 17.5 && (t * 10) % 5 == 0;
    }
}
