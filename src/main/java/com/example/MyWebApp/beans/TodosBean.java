package com.example.MyWebApp.beans;

import com.example.MyWebApp.data.Task;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class TodosBean {
    private List<Task> tasks;

    @PostConstruct
    public void init() {
        tasks = new ArrayList<>();
        tasks.add(new Task(10, "Learning"));
        tasks.add(new Task(20, "Sports"));
        tasks.add(new Task(30, "Reading"));
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<Task> getTasks() {
        return tasks;
    }

}
