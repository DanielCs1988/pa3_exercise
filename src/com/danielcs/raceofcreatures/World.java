package com.danielcs.raceofcreatures;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class World {

    private Weather weather;
    private int currentDay;
    private String forecast;
    private List<Creature> creatures = new ArrayList<>();

    public World(String path) {
        init(path);
    }

    private void init(String path) {
        RaceData raceData = RaceData.getWorldState(path);
        forecast = raceData.getWeatherForecast();

        for (CreatureData creature : raceData.getCreatures()) {
            switch (creature.getType()) {
                case 's':
                    creatures.add(new Sandwalker(creature.getName(), creature.getWaterLeft()));
                    break;
                case 'p':
                    creatures.add(new Sponge(creature.getName(), creature.getWaterLeft()));
                    break;
                case 'w':
                    creatures.add(new Walker(creature.getName(), creature.getWaterLeft()));
            }
        }
    }

    private void dayPassed() {
        switch (forecast.charAt(currentDay++)) {
            case 's':
                weather = Weather.SUNNY;
                break;
            case 'c':
                weather = Weather.CLOUDY;
                break;
            case 'r':
                weather = Weather.RAINY;
        }
        for (Creature creature : creatures) {
            creature.move(this);
        }
    }

    public String start() {
        for (int i = 0; i < forecast.length(); i++) {
            dayPassed();
            System.out.println("DAY: " + (i + 1) + " WEATHER: " + weather);
            creatures = creatures.stream()
                    .filter(Creature::isAlive)
                    .collect(Collectors.toList());
            System.out.println(creatures);
        }
        if (creatures.isEmpty()) {
            return "They are all dEd.";
        }
        return creatures.stream()
                .reduce(creatures.get(0), (a, b) -> a.getDistance() > b.getDistance() ? a : b)
                .getName();
    }

    public Weather getWeather() {
        return weather;
    }
}

enum Weather {
    SUNNY, CLOUDY, RAINY
}
