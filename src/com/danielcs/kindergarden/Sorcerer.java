package com.danielcs.kindergarden;

public class Sorcerer extends Kid {

    public Sorcerer(String name, int satisfaction) {
        super(name, satisfaction);
    }

    @Override
    public void mayhem(Kindergarden kindergarden) {
        switch (kindergarden.getActivity()) {
            case RUNECRAFTING:
                satisfaction = 4;
                break;
            case SHOOTING:
                satisfaction -= 1;
                break;
            case RITUAL:
                satisfaction -= 1;
        }
        isHappy = satisfaction > 0;
    }
}
