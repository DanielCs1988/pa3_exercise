package com.danielcs.programmers;

public class Task {

    private Difficulty difficulty;
    private int id;
    private int hoursLeft;
    private Programmer owner;

    private static int idSequence;

    private Task(Difficulty difficulty, int length, Programmer owner) {
        this.id = ++idSequence;
        this.difficulty = difficulty;
        hoursLeft = length;
        this.owner = owner;
        owner.assignTask(this);
    }

    public static Task createTask(int difficulty, int length, Programmer owner) {
        switch (difficulty) {
            case 1:
                return new Task(Difficulty.EASY, length, owner);
            case 2:
                return new Task(Difficulty.MEDIUM, length, owner);
            case 3:
                return new Task(Difficulty.HARD, length, owner);
        }
        return null;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public int getHoursLeft() {
        return hoursLeft;
    }

    public void changeHoursLeft(int amount) {
        hoursLeft += amount;
    }

    public boolean isDone() {
        return hoursLeft < 1;
    }

    @Override
    public String toString() {
        return "Task #" + id + ": " + hoursLeft + "h left";
    }
}

enum Difficulty {
    EASY, MEDIUM, HARD
}