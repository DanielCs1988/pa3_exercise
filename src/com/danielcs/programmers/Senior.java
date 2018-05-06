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
                break;
            case HARD:
                tasks.add(task);
                task.changeHoursLeft(task.getHoursLeft() * 2);
        }
    }

    @Override
    protected int getWorkCapacity() {
        return 2;
    }
}
