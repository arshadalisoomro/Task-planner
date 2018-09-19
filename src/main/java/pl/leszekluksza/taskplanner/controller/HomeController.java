package pl.leszekluksza.taskplanner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.leszekluksza.taskplanner.converter.FullTaskDtoConverter;
import pl.leszekluksza.taskplanner.dao.CategoryDao;
import pl.leszekluksza.taskplanner.dao.UserDao;
import pl.leszekluksza.taskplanner.dto.FullTaskDto;
import pl.leszekluksza.taskplanner.model.Category;
import pl.leszekluksza.taskplanner.model.Task;
import pl.leszekluksza.taskplanner.model.User;
import pl.leszekluksza.taskplanner.repository.CategoryRepository;
import pl.leszekluksza.taskplanner.repository.TaskRepository;
import pl.leszekluksza.taskplanner.repository.UserRepository;

import java.security.Principal;
import java.util.List;
import java.util.Set;

@Controller
public class HomeController {

    @Autowired
    FullTaskDtoConverter fullTaskDtoConverter;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    UserDao userDao;

    @Autowired
    CategoryDao categoryDao;

    @GetMapping("index")
    public String index(Model model, Principal principal) {
//        List<Task> tasks = taskRepository.findAll();
        User user = userRepository.findByUsername(principal.getName());
        List<Task> tasks = taskRepository.findAllByUserId(user.getId());
        model.addAttribute("tasks",tasks);
        return "index";
    }

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

    @PostMapping("/AddCategory")
    public String addCategory(@ModelAttribute Category category, Principal principal){
        categoryDao.SaveCategory(category,principal);
        return "redirect:/form?added";
    }

    @PostMapping("form")
    public String postForm(@ModelAttribute FullTaskDto fullTaskDto, Principal principal)
    {
        System.out.println("im in post form");
        if(fullTaskDtoConverter.convertAndSave(fullTaskDto,principal).equals("ok")){
            return "redirect:index";
        }
        else {
            return "redirect:form?error";
        }
    }

    @GetMapping("/login")
    public String getLoginForm(Model model){
        model.addAttribute("user",new User());
        return "login";
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model){
        model.addAttribute("user",new User());
        return "register";
    }
    @PostMapping("/register")
    public String register(@ModelAttribute User user){
        user.setRole("ROLE_USER");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "redirect:/login?created";
    }
}
