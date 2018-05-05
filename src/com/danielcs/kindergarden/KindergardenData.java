package com.danielcs.kindergarden;

import com.danielcs.utils.DataReader;

import java.util.Collections;
import java.util.List;

public class KindergardenData {

    private List<KidData> kids;
    private String plan;

    private KindergardenData() {
    }

    public static KindergardenData getKindergardenState(String filePath) {
        return new DataReader(filePath).getData(KindergardenData.class);
    }

    public List<KidData> getKids() {
        return Collections.unmodifiableList(kids);
    }

    public String getPlan() {
        return plan;
    }
}

class KidData {

    private String name;
    private String type;
    private int satisfaction;

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getSatisfaction() {
        return satisfaction;
    }
}
