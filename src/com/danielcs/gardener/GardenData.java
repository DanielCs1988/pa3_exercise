package com.danielcs.gardener;

import com.danielcs.utils.DataReader;

import java.util.Collections;
import java.util.List;

public class GardenData {

    private List<PlantData> plants;
    private String treatment;

    private GardenData() {
    }

    public static GardenData getGardenState(String filePath) {
        return new DataReader(filePath).getData(GardenData.class);
    }

    public List<PlantData> getPlants() {
        return Collections.unmodifiableList(plants);
    }

    public String getTreatment() {
        return treatment;
    }
}

class PlantData {

    private String name;
    private String type;
    private int size;

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getSize() {
        return size;
    }
}

