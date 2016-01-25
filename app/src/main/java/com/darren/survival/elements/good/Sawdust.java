package com.darren.survival.elements.good;

import com.darren.survival.elements.model.Good;
import com.darren.survival.elements.motion.good.Fireable;
import com.darren.survival.elements.motion.good.Getable;

/**
 * Created by Darren on 2015/12/15 0015.
 */
public class Sawdust extends Good implements Getable, Fireable {
    public static final double WEIGHT = 0.05;
    public static final int FIRE_TIME = 10;
    public static int COUNT = 0;
    public static final String ID = "FR3";
    private static Sawdust sawdust = new Sawdust();

    public static Sawdust getInstance() {
        return sawdust;
    }

    private Sawdust() {
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
    public int getCOUNT() {
        return COUNT;
    }

    @Override
    public void setCOUNT(int COUNT) {
        this.COUNT += COUNT;
    }

    @Override
    public String getID() {
        return ID;
    }
}
