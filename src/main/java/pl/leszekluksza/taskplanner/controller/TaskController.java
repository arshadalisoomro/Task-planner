package pl.leszekluksza.taskplanner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.leszekluksza.taskplanner.converter.FullTaskDtoConverter;
import pl.leszekluksza.taskplanner.dao.UserDao;
import pl.leszekluksza.taskplanner.dto.FullTaskDto;
import pl.leszekluksza.taskplanner.model.Category;
import pl.leszekluksza.taskplanner.model.User;
import pl.leszekluksza.taskplanner.repository.CategoryRepository;

import java.security.Principal;
import java.util.Set;

@Controller
public class TaskController {

    @Autowired
    UserDao userDao;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    FullTaskDtoConverter fullTaskDtoConverter;

    @GetMapping("form")
    public String form(Model model, Principal principal) {
        FullTaskDto fullTask = new FullTaskDto();
        User user = userDao.findUserByPrincipal(principal);
        Set<Category> categories = categoryRepository.findByUserId(user.getId());
        fullTask.setCategories(categories);
        model.addAttribute("fullTask", fullTask);
        model.addAttribute("category", new Category());
        return "form";
    }

    @PostMapping("form")
    public String postForm(@ModelAttribute FullTaskDto fullTaskDto, Principal principal)
    {
        if(fullTaskDtoConverter.convertAndSave(fullTaskDto,principal)){
            return "redirect:index";
        }
        else {
            return "redirect:form?error";
        }
    }
}
