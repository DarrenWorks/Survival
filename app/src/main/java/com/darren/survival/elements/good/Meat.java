package com.darren.survival.elements.good;

import com.darren.survival.elements.model.Good;
import com.darren.survival.elements.motion.good.Eatable;
import com.darren.survival.elements.motion.good.Makable;

/**
 * Created by Darren on 2015/12/15 0015.
 */
public class Meat extends Good implements Makable, Eatable {
    public static final double WEIGHT = 3.5;
    private int count = 0;
    public static final String ID = "ET12";
    private static Meat meat = new Meat();

    public static Meat getInstance() {
        return meat;
    }

    private Meat() {
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
