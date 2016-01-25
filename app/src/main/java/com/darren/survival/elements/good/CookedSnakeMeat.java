package com.darren.survival.elements.good;

import com.darren.survival.elements.model.Good;
import com.darren.survival.elements.motion.good.Eatable;

/**
 * Created by Darren on 2015/12/15 0015.
 */
public class CookedSnakeMeat extends Good implements Eatable {
    public static final double WEIGHT = 0.2;
    private int count = 0;
    public static final String ID = "ET15";
    private static CookedSnakeMeat cookedSnakeMeat = new CookedSnakeMeat();

    public static CookedSnakeMeat getInstance() {
        return cookedSnakeMeat;
    }

    private CookedSnakeMeat() {
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
