package com.danielcs.radiation;

import java.util.*;
import java.util.stream.Collectors;

public class World {

    private List<Plant> plants;
    private int rounds;
    private Radiation radiation = Radiation.NONE;

    public World(String filePath) {
        init(filePath);
    }

    private void init(String filePath) {
        RadiationData worldState = RadiationData.getWorldState(filePath);
        rounds = worldState.getRounds();
        plants = new ArrayList<>();

        for (PlantData plant : worldState.getPlants()) {
            switch (plant.getType()) {
                case 'a':
                    plants.add(new Puffancs(plant.getName(), plant.getFoodLeft()));
                    break;
                case 'd':
                    plants.add(new Deltafa(plant.getName(), plant.getFoodLeft()));
                    break;
                case 'p':
                    plants.add(new Parabokor(plant.getName(), plant.getFoodLeft()));
            }
        }
    }

    private void dayPassed() {
        for (Plant plant : plants) {
            plant.feed(this);
        }
    }

    private void setRadiation(int demand) {
        if (demand > 0) {
            radiation = Radiation.ALFA;
        } else if (demand < 0) {
            radiation = Radiation.DELTA;
        } else {
            radiation = Radiation.NONE;
        }
    }

    public List<String> start() {
        int radiationDemand;
        for (int i = 0; i < rounds; i++) {
            dayPassed();
            plants = plants.stream()
                    .filter(Plant::isAlive)
                    .collect(Collectors.toList());
            radiationDemand = plants.stream()
                    .map(Plant::getRadiationDemand)
                    .reduce(0, (a, b) -> a + b);
            setRadiation(radiationDemand);
        }
        return plants.stream()
                .map(Plant::getName)
                .collect(Collectors.toList());
    }

    public Radiation getRadiation() {
        return radiation;
    }
}

enum Radiation {
    NONE, ALFA, DELTA
}