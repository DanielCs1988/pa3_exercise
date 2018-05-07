package com.danielcs.antcolony;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ColonyTest {

    @Test
    void start() {
        Colony colony = new Colony();
        colony.start(100);
    }
}