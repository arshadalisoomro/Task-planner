package pl.leszekluksza.taskplanner.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.leszekluksza.taskplanner.dao.UserDao;
import pl.leszekluksza.taskplanner.dto.FullTaskDto;
import pl.leszekluksza.taskplanner.model.Category;
import pl.leszekluksza.taskplanner.model.Task;
import pl.leszekluksza.taskplanner.model.TaskComment;
import pl.leszekluksza.taskplanner.model.User;
import pl.leszekluksza.taskplanner.repository.CategoryRepository;
import pl.leszekluksza.taskplanner.repository.TaskCommentRepository;
import pl.leszekluksza.taskplanner.repository.TaskRepository;

import java.security.Principal;

@Component
public class FullTaskDtoConverter {
    @Autowired
    TaskRepository taskRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    TaskCommentRepository taskCommentRepository;

    @Autowired
    UserDao userDao;


    public String convertAndSave(FullTaskDto fullTaskDto, Principal principal){
        User user = userDao.findUserByPrincipal(principal);

        Category category = new Category();
        category.setName(fullTaskDto.getCategoryName());

        Task task = new Task();
        task.setName(fullTaskDto.getName());
        task.setEnabled(true);
        task.setCategory(category);
        task.setUser(user);

        TaskComment taskComment = new TaskComment();
        taskComment.setComment(fullTaskDto.getComment());
        taskComment.setTask(task);

        categoryRepository.save(category);
        taskRepository.save(task);
        taskCommentRepository.save(taskComment);

        return "ok";
    }




}
