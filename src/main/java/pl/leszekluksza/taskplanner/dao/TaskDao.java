package pl.leszekluksza.taskplanner.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import pl.leszekluksza.taskplanner.model.Task;
import pl.leszekluksza.taskplanner.repository.TaskRepository;

import java.util.Optional;

@Component
public class TaskDao {

    @Autowired
    TaskRepository taskRepository;

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
}
