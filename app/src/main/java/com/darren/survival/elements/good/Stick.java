package com.darren.survival.elements.good;

import com.darren.survival.elements.model.Good;

/**
 * Created by Darren on 2015/12/15 0015.
 */
public class Stick extends Good {
    public static final double WEIGHT = 5;
    public static int COUNT = 0;
    public static final String ID = "WK16";
    private static Stick stick = new Stick();

    public static Stick getInstance() {
        return stick;
    }

    private Stick() {
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
        Stick.COUNT += COUNT;
    }

    @Override
    public String getID() {
        return ID;
    }
}
