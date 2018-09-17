package pl.leszekluksza.taskplanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.leszekluksza.taskplanner.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
