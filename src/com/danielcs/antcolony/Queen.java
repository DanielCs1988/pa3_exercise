package com.danielcs.antcolony;

public class Queen extends Ant {

    private int timeUntilMating;

    public Queen(int x, int y, Colony colony) {
        super(x, y, colony);
    }

    public int getTimeUntilMating() {
        return timeUntilMating;
    }

    public void mate() {
        timeUntilMating = Ant.rnd.nextInt(100) + 100 + Ant.MATING_TIME;
    }

    @Override
    public void move() {
        if (timeUntilMating > 0) {
            timeUntilMating--;
        }
    }

    @Override
    public String toString() {
        return "Q";
    }
}
