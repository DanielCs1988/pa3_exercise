package com.danielcs.gardener;

public abstract class Plant {

    protected String name;
    protected int size;
    protected boolean isAlive = true;

    protected Plant(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public static Plant plantFactory(PlantData plant) {
        switch (plant.getType()) {
            case "Flower":
               return new Flower(plant.getName(), plant.getSize());
            case "Kush":
                return new Kush(plant.getName(), plant.getSize());
            case "Coca Plant":
                return new CocaPlant(plant.getName(), plant.getSize());
            default:
                return null;
        }
    }

    public String getName() {
        return name;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void grow(Garden garden) {
        Treatment treatment = garden.getTreatment();
        size = (treatment == Treatment.NONE) ? size - 1 : size + getReactionToTreatment(treatment);
        if (size <= 0 || size >= getMaxSize()) {
            isAlive = false;
        }
    }

    protected abstract int getReactionToTreatment(Treatment treatment);
    protected abstract int getMaxSize();

    @Override
    public String toString() {
        return "Plant{" +
                "name='" + name + '\'' +
                ", size=" + size +
                '}';
    }
}
