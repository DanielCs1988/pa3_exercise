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

    public char getType() {
        return type;
    }

    public int getFoodLeft() {
        return foodLeft;
    }
}

