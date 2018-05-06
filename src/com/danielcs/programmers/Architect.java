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
    protected int getWorkCapacity() {
        return 3;
    }
}
