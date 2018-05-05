package com.danielcs.utils;

import java.util.*;

public class TestGame {

    private List<Person> people;
    private int rounds;

    public TestGame(List<Person> people, int rounds) {
        this.people = people;
        this.rounds = rounds;
    }

    public List<Person> getPeople() {
        return Collections.unmodifiableList(people);
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }

    public int getRounds() {
        return rounds;
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }
}
