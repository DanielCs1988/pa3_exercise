package com.danielcs.raceofcreatures;

import com.danielcs.utils.DataReader;

import java.util.*;

public class RaceData {

    private List<CreatureData> creatures;
    private String weatherForecast;

    private RaceData() {
    }

    public static RaceData getWorldState(String filePath) {
        return new DataReader(filePath).getData(RaceData.class);
    }

    public List<CreatureData> getCreatures() {
        return Collections.unmodifiableList(creatures);
    }

    public String getWeatherForecast() {
        return weatherForecast;
    }
}

class CreatureData {

    private String name;
    private char type;
    private int waterLeft;

    public String getName() {
        return name;
    }

    public char getType() {
        return type;
    }

    public int getWaterLeft() {
        return waterLeft;
    }
}
