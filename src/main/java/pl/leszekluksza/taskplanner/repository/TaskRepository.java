package pl.leszekluksza.taskplanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.leszekluksza.taskplanner.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
