package pl.leszekluksza.taskplanner.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TaskCommentDto {

    @Size(min = 3)
    private String comment;

    @NotNull
    private String taskId;

    public TaskCommentDto() {
    }

    public TaskCommentDto(String name, String taskId) {
        this.comment = name;
        this.taskId = taskId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }
}
