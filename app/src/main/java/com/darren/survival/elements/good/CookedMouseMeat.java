package com.darren.survival.elements.good;

import com.darren.survival.elements.model.Good;
import com.darren.survival.elements.motion.good.Eatable;

/**
 * Created by Darren on 2015/12/15 0015.
 */
public class CookedMouseMeat extends Good implements Eatable {
    public static final double WEIGHT = 0.1;
    private int count = 0;
    public static final String ID = "ET17";
    private static CookedMouseMeat cookedMouseMeat = new CookedMouseMeat();

    public static CookedMouseMeat getInstance() {
        return cookedMouseMeat;
    }

    private CookedMouseMeat() {
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
