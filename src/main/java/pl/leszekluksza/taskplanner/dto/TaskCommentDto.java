package pl.leszekluksza.taskplanner.dto;

public class TaskCommentDto {
    private String name;
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
