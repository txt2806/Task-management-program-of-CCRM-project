package model.repository;

import model.entity.Task;
import java.util.List;

public interface ITaskRepository {

    int add(Task task);

    void delete(int id) throws Exception;

    List<Task> findAll();
}
