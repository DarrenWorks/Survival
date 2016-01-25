package com.darren.survival.elements.good;

import com.darren.survival.elements.model.Good;
import com.darren.survival.elements.motion.good.Fireable;

/**
 * Created by Darren on 2015/12/15 0015.
 */
public class Kindling extends Good implements Fireable {
    public static final double WEIGHT = 0.2;
    public static final int FIRE_TIME = 10;
    public static int COUNT = 0;
    public static final String ID ="FR6";
    private static Kindling kindling = new Kindling();

    public static Kindling getInstance() {
        return kindling;
    }

    private Kindling() {
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
        Kindling.COUNT += COUNT;
    }

    @Override
    public String getID() {
        return ID;
    }
}
