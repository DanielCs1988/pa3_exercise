package com.danielcs.antcolony;

import java.util.Random;

public abstract class Ant {

    protected static int MATING_TIME = 10;

    protected Coordinate position;
    protected Colony colony;
    protected static Random rnd = new Random();

    public Ant(int x, int y, Colony colony) {
        this.position = new Coordinate(x, y);
        this.colony = colony;
    }

    public Coordinate getPosition() {
        return position;
    }

    public void setPosition(Coordinate position) {
        this.position = position;
    }

    public abstract void move();

}
