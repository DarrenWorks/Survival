package com.darren.survival.elements.good;

import com.darren.survival.elements.model.Good;
import com.darren.survival.elements.motion.good.Huntable;

/**
 * Created by Darren on 2015/12/15 0015.
 */
public class Bug extends Good implements Huntable {
    public static final double WEIGHT = 0.01;
    private int count = 0;
    public static final String ID = "HT1";
    private static Bug bug = new Bug();

    public static Bug getInstance() {
        return bug;
    }

    private Bug() {
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
