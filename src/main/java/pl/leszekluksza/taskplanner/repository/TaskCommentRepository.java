package pl.leszekluksza.taskplanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.leszekluksza.taskplanner.model.Task;
import pl.leszekluksza.taskplanner.model.TaskComment;

public interface TaskCommentRepository extends JpaRepository<TaskComment, Long> {
}
