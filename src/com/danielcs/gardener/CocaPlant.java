package com.danielcs.gardener;

import java.util.HashMap;
import java.util.Map;

public class CocaPlant extends Plant {

    private final static int MAX_SIZE = 4;
    private Map<Treatment, Integer> reactionToTreatment = new HashMap<>();

    public CocaPlant(String name, int foodLeft) {
        super(name, foodLeft);
        reactionToTreatment.put(Treatment.WATER, -1);
        reactionToTreatment.put(Treatment.BROTH, 1);
        reactionToTreatment.put(Treatment.FERTILIZER, 1);
    }

    @Override
    protected int getReactionToTreatment(Treatment treatment) {
        return reactionToTreatment.get(treatment);
    }

    @Override
    protected int getMaxSize() {
        return MAX_SIZE;
    }
}
