package com.danielcs.programmers;

public class Junior extends Programmer {

    public Junior(String name) {
        super(name);
    }

    @Override
    public void assignTask(Task task) {
        switch (task.getDifficulty()) {
            case EASY:
                tasks.add(task);
                break;
            case MEDIUM:
                tasks.add(task);
                task.changeHoursLeft(task.getHoursLeft());
                break;
            case HARD:
                throw new IllegalArgumentException();
        }
    }

    @Override
    public void workForAnHour() {
        if (isFinished()) {
            return;
        }
        if (currentTasks.isEmpty()) {
            currentTasks.add(tasks.remove(0));
        }
        currentTasks.get(0).changeHoursLeft(-1);
    }
}
