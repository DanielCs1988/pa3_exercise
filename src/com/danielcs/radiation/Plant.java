package com.danielcs.radiation;

import java.util.HashMap;
import java.util.Map;

public abstract class Plant {

    protected String name;
    protected int foodLeft;
    protected boolean isAlive = true;
    protected int radiationDemand;
    protected Map<Radiation, Integer> reactionToRadiation = new HashMap<>();

    protected Plant(String name, int foodLeft) {
        this.name = name;
        this.foodLeft = foodLeft;
    }

    public String getName() {
        return name;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public int getRadiationDemand() {
        return radiationDemand;
    }

    @Override
    public String toString() {
        return "Plant{" +
                "name='" + name + '\'' +
                ", size=" + foodLeft +
                ", radiationDemand=" + radiationDemand +
                '}';
    }

    abstract void feed(World world);
}
