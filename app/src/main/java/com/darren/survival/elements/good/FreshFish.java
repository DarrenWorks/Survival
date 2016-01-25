package com.darren.survival.elements.good;

import com.darren.survival.elements.model.Good;
import com.darren.survival.elements.motion.good.Makable;

/**
 * Created by Darren on 2015/12/15 0015.
 */
public class FreshFish extends Good implements Makable {
    public static final double WEIGHT = 0.3;
    private int count = 0;
    public static final String ID = "WK9";
    private static FreshFish freshFish = new FreshFish();

    public static FreshFish getInstance() {
        return freshFish;
    }

    private FreshFish() {
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
