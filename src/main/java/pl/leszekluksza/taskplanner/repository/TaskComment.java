package pl.leszekluksza.taskplanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskComment extends JpaRepository<TaskComment, Long> {
}
