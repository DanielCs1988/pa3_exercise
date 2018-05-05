package com.danielcs.kindergarden;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KindergardenTest {

    private static Kindergarden kindergarden;

    @BeforeAll
    static void init() {
        kindergarden = new Kindergarden("./tests/com/danielcs/kindergarden/kgt.json");
    }

    @Test
    void start() {
        boolean kgState = kindergarden.start();
        assertTrue(kgState);
    }

}