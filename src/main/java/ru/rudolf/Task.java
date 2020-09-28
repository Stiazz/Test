package ru.rudolf;

public class Task extends AbstractElement {


    private TaskType taskType;

    public TaskType getTaskType() {
        return taskType;
    }

    public void setTaskType(TaskType taskType) {
        this.taskType = taskType;
    }
}
