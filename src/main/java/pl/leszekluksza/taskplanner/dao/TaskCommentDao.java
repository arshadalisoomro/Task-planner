package pl.leszekluksza.taskplanner.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.leszekluksza.taskplanner.model.User;

import java.security.Principal;

@Component
public class TaskCommentDao {

    @Autowired
    UserDao userDao;

    public Boolean checkIfTaskIdIsConnectedWithPrincipalAndEnabled(Principal principal, String taskId){
        User user = userDao.findUserByPrincipal(principal);
        return user.getTasks().stream().anyMatch(x->x.getId().equals(Long.valueOf(taskId))&&x.getEnabled());
    }

    public String checkTaskIdAndPrincipalAndReturnAddNotePageOrRedirect
            (String taskId, Principal principal) {
            return checkIfTaskIdIsConnectedWithPrincipalAndEnabled(principal,taskId) ? "addComment" : "redirect:/index" ;

    }
}
