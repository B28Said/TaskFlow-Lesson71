
package kg.megalab.taskflow;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;


@Repository
public class InMemoryTaskRepository implements TaskRepository {

    private final Map<Long, Task> storage = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong();

    @Override
    public Task save(Task task) {
        if (task.getId() == null) {
            task.setId(idGenerator.incrementAndGet());
        }

        storage.put(task.getId(), task);
        return task;
    }

    @Override
    public Optional<Task> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<Task> findAll() {
        return new ArrayList<>(storage.values());
    }
}
