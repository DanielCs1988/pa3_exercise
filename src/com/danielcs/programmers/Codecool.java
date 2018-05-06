package com.danielcs.programmers;

import java.util.*;

public class Codecool {

    private List<Programmer> programmers;
    private Map<String, Integer> workHours = new TreeMap<>();

    public Codecool(String path) {
        init(path);
    }

    private void init(String path) {
        CodecoolData data = CodecoolData.getCodecoolState(path);
        programmers = new LinkedList<>();
        for (ProgrammerData programmer : data.getProgrammers()) {
            programmers.add(Programmer.spawnCoder(programmer.getType(), programmer.getName()));
        }
        for (TaskData task : data.getTasks()) {
            Task.createTask(task.getDifficulty(), task.getLength(), programmers.get(task.getProgrammerIndex()));
        }
    }

    public Map<String, Integer> start() {
        runProject();
        return getStatistics();
    }

    private void runProject() {
        while (!programmers.isEmpty()) {
            Iterator<Programmer> iterator = programmers.iterator();
            while (iterator.hasNext()) {
                Programmer programmer = iterator.next();
                programmer.workForAnHour();
                if (programmer.isFinished()) {
                    workHours.put(programmer.getName(), programmer.getWorkHoursTotal());
                    iterator.remove();
                }
            }
        }
    }

    private Map<String, Integer> getStatistics() {
        int workHoursSum = workHours.values().stream().reduce(0, (a ,b) -> a + b);
        System.out.println("\n---PROJECT FINISHED. TOTAL WORK HOURS: " + workHoursSum + "\n");
        workHours.forEach((k, v) -> System.out.printf("%s worked for %d hours on the project, which is %.2f percent " +
                "of the total.\n", k, v, v / (float)workHoursSum * 100));
        return workHours;
    }
}
