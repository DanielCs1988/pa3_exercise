package com.danielcs.kindergarden;

public class Berserker extends Kid {

    public Berserker(String name, int satisfaction) {
        super(name, satisfaction);
    }

    @Override
    public void mayhem(Kindergarden kindergarden) {
        switch (kindergarden.getActivity()) {
            case SHOOTING:
                satisfaction = 4;
                break;
            case SINGING:
                satisfaction -= 1;
                break;
            case RUNECRAFTING:
                satisfaction -= 1;
        }
        isHappy = satisfaction > 0;
    }
}
