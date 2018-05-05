package com.danielcs.radiation;

public class Parabokor extends Plant {

    public Parabokor(String name, int foodLeft) {
        super(name, foodLeft);
        reactionToRadiation.put(Radiation.ALFA, 1);
        reactionToRadiation.put(Radiation.NONE, -1);
        reactionToRadiation.put(Radiation.DELTA, 1);
    }

    @Override
    void feed(World world) {
        foodLeft += reactionToRadiation.get(world.getRadiation());
        if (foodLeft <= 0) {
            isAlive = false;
        }
    }
}
