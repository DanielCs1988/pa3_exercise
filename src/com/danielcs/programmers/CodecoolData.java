package com.danielcs.programmers;

import com.danielcs.utils.DataReader;
import java.util.*;

public class CodecoolData {

    private List<ProgrammerData> programmers;
    private List<TaskData> tasks;

    private CodecoolData() {
    }

    public static CodecoolData getCodecoolState(String path) {
        return new DataReader(path).getData(CodecoolData.class);
    }

    public List<ProgrammerData> getProgrammers() {
        return Collections.unmodifiableList(programmers);
    }

    public List<TaskData> getTasks() {
        return Collections.unmodifiableList(tasks);
    }
}

class ProgrammerData {

    private String name;
    private String type;

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}

class TaskData {

    private int difficulty;
    private int length;
    private int programmerIndex;

    public int getDifficulty() {
        return difficulty;
    }

    public int getLength() {
        return length;
    }

    public int getProgrammerIndex() {
        return programmerIndex;
    }
}
