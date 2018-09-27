package pl.leszekluksza.taskplanner.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TaskCommentDto {

    @Size(min = 3)
    private String name;
    
    @NotNull
    private String taskId;

    public TaskCommentDto() {
    }

    public TaskCommentDto(String name, String taskId) {
        this.name = name;
        this.taskId = taskId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }
}
