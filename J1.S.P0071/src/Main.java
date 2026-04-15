
import controller.TaskController;
import model.repository.TaskRepository;
import model.service.TaskService;

public class Main {

    public static void main(String[] args) {
        TaskRepository repo = new TaskRepository();
        TaskService service = new TaskService(repo);
        TaskController controller = new TaskController(service);

        controller.run();
    }
}
