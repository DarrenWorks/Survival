package com.darren.survival.elements.good;

import com.darren.survival.elements.model.Good;

/**
 * Created by Darren on 2015/12/15 0015.
 */
public class Boat extends Good {
    public static final double WEIGHT = 0;
    public static int COUNT = 0;
    public static final String ID = "WK19";
    private static Boat boat = new Boat();

    public static Boat getInstance() {
        return boat;
    }

    private Boat() {
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
        Boat.COUNT += COUNT;
    }

    @Override
    public String getID() {
        return ID;
    }
}
