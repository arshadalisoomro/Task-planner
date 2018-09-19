package pl.leszekluksza.taskplanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.leszekluksza.taskplanner.model.Category;

import java.util.Set;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Set<Category> findByUserId(Long userId);

    Category findByUserIdAndName(Long id, String name);
}
