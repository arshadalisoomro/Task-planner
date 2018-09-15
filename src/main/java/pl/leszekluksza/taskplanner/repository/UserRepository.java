package pl.leszekluksza.taskplanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.leszekluksza.taskplanner.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
}
