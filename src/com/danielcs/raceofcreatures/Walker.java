package com.danielcs.raceofcreatures;

public class Walker extends Creature {

    private final static int WATER_CAPACITY = 12;

    public Walker(String name, int waterLeft) {
        super(name, waterLeft);
        waterChange.put(Weather.SUNNY, -2);
        waterChange.put(Weather.CLOUDY, -1);
        waterChange.put(Weather.RAINY, 3);
        maxSpeed.put(Weather.SUNNY, 1);
        maxSpeed.put(Weather.CLOUDY, 2);
        maxSpeed.put(Weather.RAINY, 1);
    }

    @Override
    protected int getWaterCapacity() {
        return WATER_CAPACITY;
    }
}
