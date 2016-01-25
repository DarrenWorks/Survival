package com.darren.survival.elements.good;

import com.darren.survival.elements.model.Good;
import com.darren.survival.elements.motion.good.Eatable;

/**
 * Created by Darren on 2015/12/15 0015.
 */
public class CookedRabbiteMeat extends Good implements Eatable {
    public static final double WEIGHT = 0.45;
    public static int COUNT = 0;
    public static final String ID = "ET9";
    private static CookedRabbiteMeat cookedRabbiteMeat = new CookedRabbiteMeat();

    public static CookedRabbiteMeat getInstance() {
        return cookedRabbiteMeat;
    }

    private CookedRabbiteMeat() {
    }

    @Override
    public double getWEIGHT() {
        return WEIGHT;
    }

    @Override
    public int getCOUNT() {
        return COUNT;
    }

    @Override
    public void setCOUNT(int COUNT) {
        CookedRabbiteMeat.COUNT += COUNT;
    }

    @Override
    public String getID() {
        return ID;
    }
}
