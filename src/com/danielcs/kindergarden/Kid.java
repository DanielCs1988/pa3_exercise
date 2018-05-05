package com.danielcs.kindergarden;

public abstract class Kid {

    protected String name;
    protected int satisfaction;
    protected boolean isHappy = true;

    protected Kid(String name, int satisfaction) {
        this.name = name;
        this.satisfaction = satisfaction;
    }

    public static Kid kidFactory(KidData kid) {
        switch (kid.getType()) {
            case "Bard":
                return new Bard(kid.getName(), kid.getSatisfaction());
            case "Sorcerer":
                return new Sorcerer(kid.getName(), kid.getSatisfaction());
            case "Berserker":
                return new Berserker(kid.getName(), kid.getSatisfaction());
            default:
                return null;
        }
    }

    public String getName() {
        return name;
    }

    public boolean isHappy() {
        return isHappy;
    }

    @Override
    public String toString() {
        return "Kid{" +
                "name='" + name + '\'' +
                ", satisfaction=" + satisfaction +
                ", isHappy=" + isHappy +
                '}';
    }

    public abstract void mayhem(Kindergarden kindergarden);
}
