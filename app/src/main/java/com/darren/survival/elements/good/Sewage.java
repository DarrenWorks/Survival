package com.darren.survival.elements.good;

import com.darren.survival.elements.model.Good;

/**
 * Created by Darren on 2015/12/15 0015.
 */
public class Sewage extends Good {
    public static final double WEIGHT = 0.5;
    private int count = 0;
    public static final String ID = "ET4";
    private static Sewage ourInstance = new Sewage();

    public static Sewage getInstance() {
        return ourInstance;
    }

    private Sewage() {
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
