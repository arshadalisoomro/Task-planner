package pl.leszekluksza.taskplanner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.leszekluksza.taskplanner.dao.TaskDao;
import pl.leszekluksza.taskplanner.model.Task;

@RestController
@RequestMapping("api/Task")
public class TaskRestController {

    @Autowired
    TaskDao taskDao;

    @PostMapping("/")
    public ResponseEntity<String> addTask(@RequestParam Task task){
        return taskDao.add(task);
    }

    @PostMapping("/Finish")
    public ResponseEntity<String> finishTask(@RequestParam String taskId)
    {
        return taskDao.finish(taskId);
    }

    @PutMapping("/Edit/{id}")
    public ResponseEntity<String> editTask(@ModelAttribute Task task, @PathVariable String id){
        return taskDao.edit(task, id);
    }


}
