package com.danielcs.raceofcreatures;

public class Sponge extends Creature {

    private final static int WATER_CAPACITY = 20;

    public Sponge(String name, int waterLeft) {
        super(name, waterLeft);
        waterChange.put(Weather.SUNNY, -4);
        waterChange.put(Weather.CLOUDY, -1);
        waterChange.put(Weather.RAINY, 6);
        maxSpeed.put(Weather.SUNNY, 0);
        maxSpeed.put(Weather.CLOUDY, 1);
        maxSpeed.put(Weather.RAINY, 3);
    }

    @Override
    protected int getWaterCapacity() {
        return WATER_CAPACITY;
    }
}
