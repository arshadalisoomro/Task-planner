package pl.leszekluksza.taskplanner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.leszekluksza.taskplanner.dao.TaskCommentDao;

import java.security.Principal;

@Controller
public class TaskCommentController {

    @Autowired
    TaskCommentDao taskCommentDao;

    @GetMapping("AddNote")
    public String AddNote(@RequestParam String taskId, Principal principal){
        return taskCommentDao.checkTaskIdAndPrincipalAndReturnAddNotePageOrRedirect(taskId,principal);
    }
}
