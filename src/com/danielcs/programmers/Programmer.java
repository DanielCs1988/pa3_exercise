package com.danielcs.programmers;

import java.util.*;

public abstract class Programmer {

    protected String name;
    protected List<Task> tasks = new LinkedList<>();
    protected List<Task> currentTasks = new LinkedList<>();

    protected Programmer(String name) {
        this.name = name;
    }

    public static Programmer spawnCoder(String type, String name) {
        switch (type) {
            case "junior":
                return new Junior(name);
            case "senior":
                return new Senior(name);
            case "architect":
                return new Architect(name);
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public List<Task> getCurrentTasks() {
        return Collections.unmodifiableList(currentTasks);
    }

    public boolean isFinished() {
        return tasks.isEmpty() && currentTasks.isEmpty();
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }

    public abstract void assignTask(Task task);
    public abstract void workForAnHour();
}
