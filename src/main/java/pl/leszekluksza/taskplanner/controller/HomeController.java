package pl.leszekluksza.taskplanner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.leszekluksza.taskplanner.converter.FullTaskDtoConverter;
import pl.leszekluksza.taskplanner.dto.FullTaskDto;

import java.security.Principal;

@Controller
public class HomeController {

    @Autowired
    FullTaskDtoConverter fullTaskDtoConverter;



    @GetMapping("index")
    public String index() {
        return "index";
    }

    @GetMapping("form")
    public String form(Model model, Principal principal) {
        model.addAttribute("fullTask", new FullTaskDto());
        return "form";
    }

    @PostMapping("form")
    public String postForm(@ModelAttribute FullTaskDto fullTaskDto)
    {
        System.out.println("im in post form");
        if(fullTaskDtoConverter.convertAndSave(fullTaskDto).equals("ok")){
            return "redirect:index";
        }
        else {
            return "redirect:form?error";
        }
    }
}
