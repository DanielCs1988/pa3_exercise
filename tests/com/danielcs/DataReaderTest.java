package com.danielcs;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataReaderTest {

    @Test
    void testGetData() {
        DataReader reader = new DataReader("./tests/com/danielcs/test.txt");
        List<Person> people = reader.getData(Person.class);
        assertEquals("Daniel", people.get(0).getName());
        assertEquals(29, people.get(0).getAge());
        assertEquals("Nicole", people.get(2).getName());
        assertEquals(23, people.get(2).getAge());
    }
}