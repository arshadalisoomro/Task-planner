package pl.leszekluksza.taskplanner.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import pl.leszekluksza.taskplanner.dao.UserDao;
import pl.leszekluksza.taskplanner.dto.TaskCommentDto;
import pl.leszekluksza.taskplanner.model.Task;
import pl.leszekluksza.taskplanner.model.TaskComment;
import pl.leszekluksza.taskplanner.model.User;
import pl.leszekluksza.taskplanner.repository.TaskCommentRepository;
import pl.leszekluksza.taskplanner.repository.TaskRepository;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Optional;

@Component
public class TaskCommentDtoConverter {

    @Autowired
    UserDao userDao;

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    TaskCommentRepository taskCommentRepository;

    public String validateConvertSaveAndReturnIndex(TaskCommentDto taskCommentDto, Principal principal, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "/index?error=addNote";
        }
        try {
            User user = userDao.findUserByPrincipal(principal);
            if(user.getTasks().stream()
                    .anyMatch(x->x.getId().equals(Long.valueOf(taskCommentDto.getTaskId())))) {
                TaskComment taskComment = new TaskComment();
                Task task = taskRepository.getOne(Long.valueOf(taskCommentDto.getTaskId()));
                taskComment.setTask(task);
                taskComment.setComment(taskCommentDto.getComment());
                taskCommentRepository.save(taskComment);
                return "/index?success=addNote";
            }
        } catch (NumberFormatException e) {
            return "/index?error=addNote";
        }
        return "/index?error=addNote";
    }
}
