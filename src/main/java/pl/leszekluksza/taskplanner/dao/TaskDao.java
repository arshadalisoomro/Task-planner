package pl.leszekluksza.taskplanner.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.leszekluksza.taskplanner.model.Task;
import pl.leszekluksza.taskplanner.repository.TaskRepository;

import java.util.Optional;

@Component
public class TaskDao {

    @Autowired
    TaskRepository taskRepository;

    public String add(Task task) {
        taskRepository.save(new Task());
        return "saved";
    }

    public String finish(String taskId) {
        Optional<Task> task = taskRepository.findById(Long.valueOf(taskId));
        if(task.isPresent())
        {
            Task taskToFinish = task.get();
            taskToFinish.setEnabled(false);
            taskRepository.save(taskToFinish);
            return "Task has been successfully finished";
        }
        else{
            return "Task does not exist";
        }
    }

    public String edit(Task task, String id) {
        if (task.getId().equals(id)) {
            taskRepository.save(task);
            return "edited";
        } else {
            return "task id is not corrected";
        }
    }
}
