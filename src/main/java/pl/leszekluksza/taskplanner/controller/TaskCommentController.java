package pl.leszekluksza.taskplanner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.leszekluksza.taskplanner.converter.TaskCommentDtoConverter;
import pl.leszekluksza.taskplanner.dao.TaskCommentDao;
import pl.leszekluksza.taskplanner.dto.TaskCommentDto;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class TaskCommentController {

    @Autowired
    TaskCommentDao taskCommentDao;

    @Autowired
    TaskCommentDtoConverter taskCommentDtoConverter;

    @GetMapping("/AddNote")
    public String AddNote(@RequestParam String taskId, Principal principal, Model model){
        model.addAttribute("taskCommentDto",new TaskCommentDto());
        return taskCommentDao.checkTaskIdAndPrincipalAndReturnAddNotePageOrRedirect(taskId,principal);
    }
    @PostMapping("/AddNote")
    public String AddNoteReceivePostRequest(@ModelAttribute @Valid TaskCommentDto taskCommentDto, Principal principal, BindingResult bindingResult){
        return taskCommentDtoConverter.validateConvertSaveAndReturnIndex(taskCommentDto, principal, bindingResult);
    }
}
