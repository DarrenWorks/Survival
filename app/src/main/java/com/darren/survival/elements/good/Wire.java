package com.darren.survival.elements.good;

import com.darren.survival.elements.model.Good;
import com.darren.survival.elements.motion.good.Makable;

/**
 * Created by Darren on 2015/12/15 0015.
 */
public class Wire extends Good implements Makable {
    public static final double WEIGHT = 0.01;
    private int count = 0;
    public static final String ID = "WK3";
    private static Wire wire = new Wire();

    public static Wire getInstance() {
        return wire;
    }

    private Wire() {
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
