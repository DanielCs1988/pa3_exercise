package com.danielcs.gardener;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Garden {

    private List<Plant> plants;
    private String treatmentPlans;
    private int currentDay;
    private Treatment treatment;

    public Garden(String filePath) {
        init(filePath);
    }

    private void init(String filePath) {
        GardenData worldState = GardenData.getGardenState(filePath);
        treatmentPlans = worldState.getTreatment();
        plants = new ArrayList<>();
        for (PlantData plant : worldState.getPlants()) {
            plants.add(Plant.plantFactory(plant));
        }
    }

    private void dayPassed() {
        setTreatment(treatmentPlans.charAt(currentDay++));
        for (Plant plant : plants) {
            plant.grow(this);
        }
    }

    private void setTreatment(char numCode) {
        switch (numCode) {
            case '0':
                treatment = Treatment.NONE;
                break;
            case '1':
                treatment = Treatment.WATER;
                break;
            case '2':
                treatment = Treatment.BROTH;
                break;
            case '3':
                treatment = Treatment.FERTILIZER;
        }
    }

    public List<String> start() {
        for (int i = 0; i < treatmentPlans.length(); i++) {
            dayPassed();
            plants = plants.stream()
                    .filter(Plant::isAlive)
                    .collect(Collectors.toList());
            System.out.println("DAY: " + currentDay + " TREATMENT: " + treatment);
            System.out.println(plants);
        }
        return plants.stream()
                .map(Plant::getName)
                .collect(Collectors.toList());
    }

    public Treatment getTreatment() {
        return treatment;
    }
}

enum Treatment {
    NONE, WATER, BROTH, FERTILIZER
}