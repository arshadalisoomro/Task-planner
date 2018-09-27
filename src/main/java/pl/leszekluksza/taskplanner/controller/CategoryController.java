package pl.leszekluksza.taskplanner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.leszekluksza.taskplanner.dao.CategoryDao;
import pl.leszekluksza.taskplanner.model.Category;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class CategoryController {

    @Autowired
    CategoryDao categoryDao;

    @PostMapping("/AddCategory")
    public String addCategory(@ModelAttribute @Valid Category category, Principal principal, BindingResult bindingResult){
        return categoryDao.SaveCategoryAndRedirectToForm(category,principal,bindingResult);
    }
}
