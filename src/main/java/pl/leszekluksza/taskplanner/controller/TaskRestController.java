package pl.leszekluksza.taskplanner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.leszekluksza.taskplanner.dao.TaskDao;
import pl.leszekluksza.taskplanner.model.Task;

@RestController
@RequestMapping("api/Task")
public class TaskRestController {

    @Autowired
    TaskDao taskDao;

    @PostMapping("/")
    public String addTask(@RequestParam Task task){
        return taskDao.add(task);
    }

    @GetMapping("/finish")
    public String finishTask(@RequestParam String taskId)
    {
        return taskDao.finish(taskId);
    }




}
