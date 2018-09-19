package pl.leszekluksza.taskplanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import pl.leszekluksza.taskplanner.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
    UserDetails getUserByUsername(String username);

    User findByUsername(String username);
}
