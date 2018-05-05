package com.danielcs;

import com.danielcs.utils.DataReader;
import com.danielcs.utils.TestGame;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataReaderTest {

    @Test
    void testGetData() {
        DataReader reader = new DataReader("./tests/com/danielcs/test.json");
        TestGame testGame = reader.getData(TestGame.class);
        assertEquals(10, testGame.getRounds());
        assertEquals("Daniel", testGame.getPeople().get(0).getName());
        assertEquals(23, testGame.getPeople().get(2).getAge());
    }
}