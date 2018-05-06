package com.danielcs.programmers;

import java.util.Iterator;

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
    protected int getWorkCapacity() {
        return 1;
    }
}
