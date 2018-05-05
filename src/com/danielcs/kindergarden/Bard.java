package com.danielcs.kindergarden;

public class Bard extends Kid {

    public Bard(String name, int satisfaction) {
        super(name, satisfaction);
    }

    @Override
    public void mayhem(Kindergarden kindergarden) {
        switch (kindergarden.getActivity()) {
            case SINGING:
                satisfaction = 4;
                break;
            case SHOOTING:
                satisfaction -= 1;
                break;
            case RUNECRAFTING:
                satisfaction -= 1;
        }
        isHappy = satisfaction > 0;
    }
}
