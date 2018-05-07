package com.danielcs.antcolony;

public class Soldier extends Ant {

    private Direction currentDirection = Direction.NORTH;

    public Soldier(int x, int y, Colony colony) {
        super(x, y, colony);
    }

    @Override
    public void move() {
        switch (currentDirection) {
            case NORTH:
                colony.changeCoords(this, new Coordinate(position.x, position.y - 1));
                currentDirection = Direction.EAST;
                break;
            case SOUTH:
                colony.changeCoords(this, new Coordinate(position.x, position.y + 1));
                currentDirection = Direction.WEST;
                break;
            case WEST:
                colony.changeCoords(this, new Coordinate(position.x - 1, position.y));
                currentDirection = Direction.NORTH;
                break;
            case EAST:
                colony.changeCoords(this, new Coordinate(position.x + 1, position.y));
                currentDirection = Direction.SOUTH;
        }
    }

    @Override
    public String toString() {
        return "S";
    }
}

enum Direction {
    NORTH, SOUTH, WEST, EAST
}
