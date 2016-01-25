package com.darren.survival.elements.good;

import com.darren.survival.elements.model.Good;
import com.darren.survival.elements.motion.good.Fireable;

/**
 * Created by Darren on 2015/12/15 0015.
 */
public class Lighter extends Good implements Fireable {
    public static final double WEIGHT = 0.01;
    public static final int FIRE_TIME = 10;
    public static final String ID ="FR4";
    private static Lighter lighter = new Lighter();
    private int count = 0;

    private Lighter() {
    }

    public static Lighter getInstance() {
        return lighter;
    }

    @Override
    public double getWEIGHT() {
        return WEIGHT;
    }

    @Override
    public int getFireTime() {
        return FIRE_TIME;
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
