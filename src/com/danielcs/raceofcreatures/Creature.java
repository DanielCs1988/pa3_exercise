package com.danielcs.raceofcreatures;

import java.util.HashMap;
import java.util.Map;

public abstract class Creature {

    protected String name;
    protected int waterLeft;
    protected int distance;
    protected boolean isAlive = true;

    protected Map<Weather, Integer> maxSpeed = new HashMap<>();
    protected Map<Weather, Integer> waterChange = new HashMap<>();

    protected Creature(String name, int waterLeft) {
        this.name = name;
        this.waterLeft = waterLeft;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public boolean isAlive() {
        return isAlive;
    }

    @Override
    public String toString() {
        return "Kid{" +
                "name='" + name + '\'' +
                ", satisfaction=" + waterLeft +
                ", distance=" + distance +
                '}';
    }

    public void move(World world) {
        waterLeft += waterChange.get(world.getWeather());
        if (waterLeft < 1) {
            isAlive = false;
            return;
        }
        if (waterLeft > getWaterCapacity()) {
            waterLeft = getWaterCapacity();
        }
        distance += maxSpeed.get(world.getWeather());
    }

    protected abstract int getWaterCapacity();
}
