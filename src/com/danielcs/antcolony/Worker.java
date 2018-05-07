package com.danielcs.antcolony;

import java.util.List;

public class Worker extends Ant {

    public Worker(int x, int y, Colony colony) {
        super(x, y, colony);
    }

    @Override
    public void move() {
        List<Coordinate> validCoords = colony.getValidCoords(position, 1);
        if (!validCoords.isEmpty()) {
            colony.changeCoords(this, validCoords.get(Ant.rnd.nextInt(validCoords.size())));
        }
    }

    @Override
    public String toString() {
        return "W";
    }
}
