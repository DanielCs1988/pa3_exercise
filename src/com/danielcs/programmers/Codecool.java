package com.danielcs.programmers;

import java.util.*;

public class Codecool {

    private List<Programmer> programmers;

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

    public void start() {
        while (!programmers.isEmpty()) {
            Iterator<Programmer> iterator = programmers.iterator();
            while (iterator.hasNext()) {
                Programmer programmer = iterator.next();
                programmer.workForAnHour();
                if (programmer.isFinished()) {
                    iterator.remove();
                    continue;
                }
                System.out.print(programmer.getName() + "is working on tasks: " + programmer.getCurrentTasks());
            }
        }
    }
}
