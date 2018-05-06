package com.danielcs.programmers;

import java.util.*;

public abstract class Programmer {

    protected List<Task> tasks = new LinkedList<>();
    private List<Task> currentTasks = new LinkedList<>();
    private String name;
    private int workHoursTotal;

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

    public int getWorkHoursTotal() {
        return workHoursTotal;
    }

    public boolean isFinished() {
        return tasks.isEmpty() && currentTasks.isEmpty();
    }

    public void workForAnHour() {
        while (currentTasks.size() < getWorkCapacity() && tasks.size() > 0) {
            currentTasks.add(tasks.remove(0));
        }
        System.out.println(name + " is working on tasks: " + currentTasks);

        Iterator<Task> iterator = currentTasks.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            task.changeHoursLeft(-1);
            if (task.isDone()) {
                iterator.remove();
            }
        }
        workHoursTotal++;
    }

    public abstract void assignTask(Task task);
    protected abstract int getWorkCapacity();
}
