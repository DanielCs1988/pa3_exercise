package com.danielcs.radiation;

public class Puffancs extends Plant {

    public Puffancs(String name, int foodLeft) {
        super(name, foodLeft);
        reactionToRadiation.put(Radiation.ALFA, 2);
        reactionToRadiation.put(Radiation.NONE, -1);
        reactionToRadiation.put(Radiation.DELTA, -2);
    }

    @Override
    void feed(World world) {
        foodLeft += reactionToRadiation.get(world.getRadiation());
        radiationDemand = 10 - foodLeft;
        if (foodLeft <= 0 || foodLeft > 10) {
            isAlive = false;
        }
    }
}
