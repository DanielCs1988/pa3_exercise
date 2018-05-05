package com.danielcs.radiation;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RadiationTest {

    private static World world;

    @BeforeAll
    static void init() {
        world = new World("./tests/com/danielcs/radiation/radiation.json");
    }

    @Test
    void start() {
        List<String> survivors = world.start();
        String expected = "[Devourer, Thinboi, Tinyboi, Fuccboi]";
        assertEquals(expected, survivors.toString());
    }
}