package com.danielcs.programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CodecoolTest {

    @Test
    void testCoding() {
        Codecool codecool = new Codecool("./tests/com/danielcs/programmers/codecool.json");
        codecool.start();
    }
}