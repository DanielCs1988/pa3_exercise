package com.danielcs.antcolony;

import java.util.List;

public class Drone extends Ant {

    private int matingCountdown = -1;

    public Drone(int x, int y, Colony colony) {
        super(x, y, colony);
    }

    @Override
    public void move() {
        if (matingCountdown > 0) {
            matingCountdown--;
            return;
        }
        if (matingCountdown == 0) {
            matingCountdown = -1;
            gettingAssKicked();
            return;
        }
        if (distanceToQueen() <= 3) {
            if (colony.isQueenMating()) {
                gettingAssKicked();
            } else {
                matingCountdown = Ant.MATING_TIME;
                colony.mateWithTheQueen();
            }
            return;
        }
        seekTheQueen();
    }

    private void seekTheQueen() {
        int queenX = colony.getQueenCoords().x;
        int queenY = colony.getQueenCoords().y;
        List<Coordinate> validCoords = colony.getValidCoords(position, 1);
        for (Coordinate coord : validCoords) {
            if (queenX > position.x && coord.x > position.x) {
                colony.changeCoords(this, coord);
            } else if (queenX < position.x && coord.x < position.x) {
                colony.changeCoords(this, coord);
            } else if (queenY > position.y && coord.y > position.y) {
                colony.changeCoords(this, coord);
            } else if (queenY > position.y && coord.y > position.y) {
                colony.changeCoords(this, coord);
            }
        }
    }

    private void gettingAssKicked() {
        List<Coordinate> validKickPositions = colony.getValidCoords(position, Colony.LIMIT_X / 2);
        if (!validKickPositions.isEmpty()) {
            colony.changeCoords(this, validKickPositions.get(Ant.rnd.nextInt(validKickPositions.size())));
        }
    }

    private int distanceToQueen() {
        return Math.abs(colony.getQueenCoords().x - position.x) + Math.abs(colony.getQueenCoords().y - position.y);
    }

    @Override
    public String toString() {
        return "D";
    }
}
