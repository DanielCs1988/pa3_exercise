package com.danielcs.raceofcreatures;

public class Sandwalker extends Creature {

    private static final int WATER_CAPACITY = 8;

    public Sandwalker(String name, int waterLeft) {
        super(name, waterLeft);
        waterChange.put(Weather.SUNNY, -1);
        waterChange.put(Weather.CLOUDY, 0);
        waterChange.put(Weather.RAINY, 3);
        maxSpeed.put(Weather.SUNNY, 3);
        maxSpeed.put(Weather.CLOUDY, 1);
        maxSpeed.put(Weather.RAINY, 0);
    }

    @Override
    protected int getWaterCapacity() {
        return WATER_CAPACITY;
    }
}
