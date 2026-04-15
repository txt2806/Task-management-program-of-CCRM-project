package model.repository;

import model.entity.Task;
import java.util.*;

public class TaskRepository implements ITaskRepository {

    private List<Task> list = new ArrayList<>();

    @Override
    public int add(Task task) {
        list.add(task);
        return task.getId();
    }

    @Override
    public void delete(int id) throws Exception {
        boolean removed = list.removeIf(t -> t.getId() == id);
        if (!removed) {
            throw new Exception("ID not found");
        }
    }

    @Override
    public List<Task> findAll() {
        list.sort(Comparator.comparingInt(Task::getId));
        return list;
    }
}
