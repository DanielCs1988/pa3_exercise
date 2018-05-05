package com.danielcs.kindergarden;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Kindergarden {

    private Activity activity;
    private int timeUnit;
    private String plan;
    private List<Kid> kids = new ArrayList<>();

    public Kindergarden(String path) {
        init(path);
    }

    private void init(String path) {
        KindergardenData kindergardenData = KindergardenData.getKindergardenState(path);
        plan = kindergardenData.getPlan();
        for (KidData kid : kindergardenData.getKids()) {
            kids.add(Kid.kidFactory(kid));
        }
    }

    private void dayPassed() {
        switch (plan.charAt(timeUnit++)) {
            case '1':
                activity = Activity.SINGING;
                break;
            case '2':
                activity = Activity.SHOOTING;
                break;
            case '3':
                activity = Activity.RUNECRAFTING;
                break;
            case '4':
                activity = Activity.RITUAL;
        }
        for (Kid kid : kids) {
            kid.mayhem(this);
        }
    }

    public boolean start() {
        for (int i = 0; i < plan.length(); i++) {
            dayPassed();
            long chaosCounter = kids.stream()
                    .filter(kid -> !kid.isHappy())
                    .count();
            System.out.println("HOUR: " + (i + 1) + " | ACTIVITY: " + activity + " | CHAOS LEVEL: " + chaosCounter);
            System.out.println(kids);
            if (chaosCounter >= 3) {
                System.out.println("-----WARNING: CHAOS ERUPTED-----");
                return false;
            }
        }
        System.out.println("Everything went fine!");
        return true;
    }

    public Activity getActivity() {
        return activity;
    }
}

enum Activity {
    SINGING, SHOOTING, RUNECRAFTING, RITUAL
}
