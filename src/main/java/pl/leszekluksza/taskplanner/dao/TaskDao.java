package pl.leszekluksza.taskplanner.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import pl.leszekluksza.taskplanner.model.Task;
import pl.leszekluksza.taskplanner.model.User;
import pl.leszekluksza.taskplanner.repository.TaskRepository;
import pl.leszekluksza.taskplanner.repository.UserRepository;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class TaskDao {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    UserRepository userRepository;

    public ResponseEntity<String> add(Task task) {
        taskRepository.save(new Task());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    public ResponseEntity<String> finish(String taskId) {
        Optional<Task> task = taskRepository.findById(Long.valueOf(taskId));
        if(task.isPresent())
        {
            Task taskToFinish = task.get();
            taskToFinish.setEnabled(false);
            taskRepository.save(taskToFinish);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    public ResponseEntity<String> edit(Task task, String id) {
        if (task.getId().equals(id)) {
            taskRepository.save(task);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    public List<Task> findTasksByPrincipal(Principal principal){
        User user = userRepository.findByUsername(principal.getName());
        List<Task> tasks = taskRepository.findAllByUserId(user.getId());
        return tasks.stream().filter(Task::getEnabled).collect(Collectors.toList());
    }
}
