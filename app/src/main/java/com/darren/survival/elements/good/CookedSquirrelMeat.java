package com.darren.survival.elements.good;

import com.darren.survival.elements.model.Good;
import com.darren.survival.elements.motion.good.Eatable;

/**
 * Created by Darren on 2015/12/15 0015.
 */
public class CookedSquirrelMeat extends Good implements Eatable {
    public static final double WEIGHT = 0.3;
    private int count = 0;
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
    public int getCount() {
        return count;
    }

    @Override
    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String getID() {
        return ID;
    }
}
