package com.danielcs.radiation;

public class Deltafa extends Plant {

    public Deltafa(String name, int foodLeft) {
        super(name, foodLeft);
        reactionToRadiation.put(Radiation.ALFA, -3);
        reactionToRadiation.put(Radiation.NONE, -1);
        reactionToRadiation.put(Radiation.DELTA, 4);
    }

    @Override
    void feed(World world) {
        foodLeft += reactionToRadiation.get(world.getRadiation());
        if (foodLeft < 5) {
            radiationDemand = -4;
        } else if (foodLeft <= 10) {
            radiationDemand = -1;
        } else {
            radiationDemand = 0;
        }
        if (foodLeft <= 0) {
            isAlive = false;
        }
    }
}