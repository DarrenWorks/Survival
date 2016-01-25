package com.darren.survival.elements.good;

import com.darren.survival.elements.model.Good;
import com.darren.survival.elements.motion.good.Makable;

/**
 * Created by Darren on 2015/12/15 0015.
 */
public class Axe extends Good implements Makable {
    public static final double WEIGHT = 1;
    private int count = 0;
    public static final String ID = "WK15";
    private static Axe axe = new Axe();

    public static Axe getInstance() {
        return axe;
    }

    private Axe() {
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
