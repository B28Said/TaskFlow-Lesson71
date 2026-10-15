package kg.megalab.taskflow;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {

    Task save(Task task);

    Optional<Task> findById(Long id);

    List<Task> findAll();
}