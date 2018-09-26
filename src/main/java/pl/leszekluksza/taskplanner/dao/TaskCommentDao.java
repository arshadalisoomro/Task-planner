package pl.leszekluksza.taskplanner.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.leszekluksza.taskplanner.model.User;

import java.security.Principal;

@Component
public class TaskCommentDao {

    @Autowired
    UserDao userDao;

    public String checkTaskIdAndPrincipalAndReturnAddNotePageOrRedirect
            (String taskId, Principal principal) {
        User user = userDao.findUserByPrincipal(principal);
        if(user==null){
            return "redirect:/index";
        }
        if(user.getTasks().stream().anyMatch(x->x.getId().equals(Long.valueOf(taskId))&&x.getEnabled())){
            return "addComment";
        }
        return "redirect:/index";
    }
}
