package pl.leszekluksza.taskplanner.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
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
    public Boolean SaveCategory(Category category, Principal principal, BindingResult bindingResult) {
        try {
            if(bindingResult.hasErrors()){
                return false;
            }
            User user = userDao.findUserByPrincipal(principal);
            category.setUser(user);
            categoryRepository.save(category);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String SaveCategoryAndRedirectToForm(Category category, Principal principal, BindingResult bindingResult){
        return SaveCategory(category, principal, bindingResult) ? "redirect:/form?added" : "redirect:/form?error";
    }
}
