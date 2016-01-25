package com.darren.survival.elements.good;

import com.darren.survival.elements.model.Good;
import com.darren.survival.elements.motion.good.Eatable;
import com.darren.survival.elements.motion.good.Makable;

/**
 * Created by Darren on 2015/12/15 0015.
 */
public class SquirrelMeat extends Good implements Makable, Eatable {
    public static final double WEIGHT = 0.3;
    private int count = 0;
    public static final String ID = "ET10";
    private static SquirrelMeat squirrelMeat = new SquirrelMeat();

    public static SquirrelMeat getInstance() {
        return squirrelMeat;
    }

    private SquirrelMeat() {
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
