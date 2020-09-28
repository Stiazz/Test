package ru.rudolf;

import io.reactivex.rxjava3.subjects.PublishSubject;

import java.util.ArrayList;
import java.util.List;

public class Requirement extends AbstractElement {
    private final List<Task> tasks;

    public Requirement() {
        this.tasks = new ArrayList<>();
    }

    @Override
    public void setState(ElementState state) {
        super.setState(state);
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task task){
        this.tasks.add(task);
    }
}
