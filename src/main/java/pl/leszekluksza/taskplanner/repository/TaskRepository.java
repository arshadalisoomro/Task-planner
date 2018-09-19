package pl.leszekluksza.taskplanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.leszekluksza.taskplanner.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {
    Optional<Task> findById(Long id);

    List<Task> findAllByUserId(Long userId);
}
