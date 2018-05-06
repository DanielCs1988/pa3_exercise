package com.danielcs.programmers;

public class Senior extends Programmer {

    public Senior(String name) {
        super(name);
    }

    @Override
    public void assignTask(Task task) {
        switch (task.getDifficulty()) {
            case EASY:
                tasks.add(task);
                task.changeHoursLeft(-(task.getHoursLeft()) / 2);
                break;
            case MEDIUM:
                tasks.add(task);
                task.changeHoursLeft(task.getHoursLeft());
                break;
            default:
                tasks.add(task);
                task.changeHoursLeft(task.getHoursLeft() * 2);
        }
    }

    @Override
    public void workForAnHour() {
        if (isFinished()) {
            return;
        }
        while (currentTasks.size() < 2 && tasks.size() > 0) {
            currentTasks.add(tasks.remove(0));
        }
        currentTasks.get(0).changeHoursLeft(-1);
        if (currentTasks.size() > 1) {
            currentTasks.get(1).changeHoursLeft(-1);
        }
    }
}
