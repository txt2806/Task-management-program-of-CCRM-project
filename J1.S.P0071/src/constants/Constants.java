package constants;

public final class Constants {

    private Constants() {
    }

    // Task Type ID
    public static final int TASK_TYPE_CODE = 1;
    public static final int TASK_TYPE_TEST = 2;
    public static final int TASK_TYPE_DESIGN = 3;
    public static final int TASK_TYPE_REVIEW = 4;

    // Task Type Name
    public static final String[] TASK_TYPE_NAMES = {"", "Code", "Test", "Design", "Review"};

    // Time range
    public static final double TIME_MIN = 8.0;
    public static final double TIME_MAX = 17.5;
    public static final double TIME_STEP = 0.5;

    // Menu choice range
    public static final int MENU_MIN = 1;
    public static final int MENU_MAX = 4;
}
