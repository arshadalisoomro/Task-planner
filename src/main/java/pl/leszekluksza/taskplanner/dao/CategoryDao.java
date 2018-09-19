package pl.leszekluksza.taskplanner.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.leszekluksza.taskplanner.model.Category;
import pl.leszekluksza.taskplanner.model.User;
import pl.leszekluksza.taskplanner.repository.CategoryRepository;

import java.security.Principal;

@Component
public class CategoryDao {
    @Autowired
    UserDao userDao;

    @Autowired
    CategoryRepository categoryRepository;

/*
* Change it to String later
* */
    public void SaveCategory(Category category, Principal principal) {
        User user = userDao.findUserByPrincipal(principal);
        category.setUser(user);
        categoryRepository.save(category);
    }
}
