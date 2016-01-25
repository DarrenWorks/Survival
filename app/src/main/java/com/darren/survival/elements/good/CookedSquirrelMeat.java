package com.darren.survival.elements.good;

import com.darren.survival.elements.model.Good;
import com.darren.survival.elements.motion.good.Eatable;

/**
 * Created by Darren on 2015/12/15 0015.
 */
public class CookedSquirrelMeat extends Good implements Eatable {
    public static final double WEIGHT = 0.3;
    public static int COUNT = 0;
    public static final String ID = "ET11";
    private static CookedSquirrelMeat cookedSquirrelMeat = new CookedSquirrelMeat();

    public static CookedSquirrelMeat getInstance() {
        return cookedSquirrelMeat;
    }

    private CookedSquirrelMeat() {
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
        CookedSquirrelMeat.COUNT += COUNT;
    }

    @Override
    public String getID() {
        return ID;
    }
}
