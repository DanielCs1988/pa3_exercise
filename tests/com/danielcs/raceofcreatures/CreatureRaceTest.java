package com.danielcs.raceofcreatures;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreatureRaceTest {

    private static World world;

    @BeforeAll
    static void init() {
        world = new World("./tests/com/danielcs/raceofcreatures/race.json");
    }

    @Test
    void start() {
        String winner = world.start();
        assertEquals("Sikló", winner);
    }

}