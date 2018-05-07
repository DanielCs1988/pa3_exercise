package com.danielcs.antcolony;

import java.io.IOException;
import java.util.*;

public class Colony {

    public static final int LIMIT_X = 41;
    public static final int LIMIT_Y = 41;

    private List<Ant> ants;
    private Ant[][] grid;
    private Queen queen;

    public Colony() {
        queen = new Queen(21, 21, this);
        grid = new Ant[LIMIT_Y][LIMIT_X];
        ants = new ArrayList<>(Arrays.asList(
                new Worker(1, 1, this),
                new Worker(28, 29, this),
                new Soldier(10, 10, this),
                new Soldier(27, 27, this),
                new Drone(40, 40, this),
                new Drone(11, 11, this),
                queen
        ));
        for (Ant ant : ants) {
            grid[ant.getPosition().y][ant.getPosition().x] = ant;
        }
    }

    public void changeCoords(Ant ant, Coordinate newCoord) {
        if (isValidCoord(newCoord.x, newCoord.y)) {
            grid[ant.getPosition().y][ant.getPosition().x] = null;
            grid[newCoord.y][newCoord.x] = ant;
        }
    }

    public Coordinate getQueenCoords() {
        return queen.getPosition();
    }

    public boolean isQueenMating() {
        return queen.getTimeUntilMating() > 0;
    }

    public void mateWithTheQueen() {
        queen.mate();
    }

    public List<Coordinate> getValidCoords(Coordinate currentPos, int distance) {
        List<Coordinate> validCoords = new ArrayList<>();
        if (isValidCoord(currentPos.x - distance, currentPos.y)) {
            validCoords.add(new Coordinate(currentPos.x - distance, currentPos.y));
        }
        if (isValidCoord(currentPos.x + distance, currentPos.y)) {
            validCoords.add(new Coordinate(currentPos.x + distance, currentPos.y));
        }
        if (isValidCoord(currentPos.x, currentPos.y - distance)) {
            validCoords.add(new Coordinate(currentPos.x, currentPos.y - distance));
        }
        if (isValidCoord(currentPos.x, currentPos.y + distance)) {
            validCoords.add(new Coordinate(currentPos.x, currentPos.y + distance));
        }
        return validCoords;
    }

    public boolean isValidCoord(int x, int y) {
        return x >= 0 && x < LIMIT_X && y >=0 && y < LIMIT_Y && grid[y][x] == null;
    }

    public void start(int rounds) {
        for (Ant ant : ants) {
            ant.move();
            try {
                renderGrid();
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void renderGrid() throws InterruptedException, IOException {
        for (Ant[] row : grid) {
            for (Ant ant : row) {
                if (ant != null) {
                    System.out.print(ant + " ");
                } else {
                    System.out.print("o ");
                }

            }
            System.out.println();
        }
        Thread.sleep(1000);
    }
}

class Coordinate {

    public int x;
    public int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
