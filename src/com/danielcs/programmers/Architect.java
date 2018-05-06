package com.danielcs.programmers;

public class Architect extends Programmer {

    public Architect(String name) {
        super(name);
    }

    @Override
    public void assignTask(Task task) {
        tasks.add(task);
        if (task.getDifficulty() == Difficulty.EASY) {
            task.changeHoursLeft(task.getHoursLeft());
        }
    }

    @Override
    public void workForAnHour() {
        if (isFinished()) {
            return;
        }
        while (currentTasks.size() < 3 && tasks.size() > 0) {
            currentTasks.add(tasks.remove(0));
        }
        currentTasks.get(0).changeHoursLeft(-1);
        if (currentTasks.size() > 1) {
            currentTasks.get(1).changeHoursLeft(-1);
        }
        if (currentTasks.size() > 2) {
            currentTasks.get(2).changeHoursLeft(-1);
        }
    }
}
