package com.danielcs.gardener;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GardenTest {

    private static Garden garden;

    @BeforeAll
    static void init() {
        garden = new Garden("./tests/com/danielcs/gardener/garden.json");
    }

    @Test
    void start() {
        List<String> survivors = garden.start();
        String expected = "[B223, K15]";
        assertEquals(expected, survivors.toString());
    }
}