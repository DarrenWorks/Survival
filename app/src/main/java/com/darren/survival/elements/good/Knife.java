package com.darren.survival.elements.good;

import com.darren.survival.elements.model.Good;
import com.darren.survival.elements.motion.good.Makable;

/**
 * Created by Darren on 2015/12/15 0015.
 */
public class Knife extends Good implements Makable {
    public static final double WEIGHT = 0.1;
    public static final String ID = "WK14";
    private int count = 0;
    private static Knife knife = new Knife();

    public static Knife getInstance() {
        return knife;
    }

    private Knife() {
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
