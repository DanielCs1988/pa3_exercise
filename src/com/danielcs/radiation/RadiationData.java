package com.danielcs.radiation;

import com.danielcs.utils.DataReader;

import java.util.*;

public class RadiationData {

    private List<PlantData> plants;
    private int rounds;

    private RadiationData() {
    }

    public static RadiationData getWorldState(String filePath) {
        return new DataReader(filePath).getData(RadiationData.class);
    }

    public List<PlantData> getPlants() {
        return Collections.unmodifiableList(plants);
    }

    public int getRounds() {
        return rounds;
    }
}

class PlantData {

    private String name;
    private char type;
    private int foodLeft;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public int getFoodLeft() {
        return foodLeft;
    }

    public void setFoodLeft(int foodLeft) {
        this.foodLeft = foodLeft;
    }
}

