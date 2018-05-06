package com.danielcs.programmers;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class CodecoolTest {

    @Test
    void testCoding() {
        Codecool codecool = new Codecool("./tests/com/danielcs/programmers/codecool.json");
        Map<String, Integer> results = codecool.start();
        Map<String, Integer> expected = new TreeMap<>();
        expected.put("ARCHITECT", 10);
        expected.put("JUNIOR", 9);
        expected.put("SENIOR", 22);
        assertEquals(expected, results);
    }
}