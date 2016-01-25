package com.darren.survival.elements.good;

import com.darren.survival.elements.model.Good;
import com.darren.survival.elements.motion.good.Makable;

/**
 * Created by Darren on 2015/12/15 0015.
 */
public class Bottle extends Good implements Makable {
    public static final double WEIGHT = 0.05;
    public static int COUNT = 0;
    public static final String ID = "WK4";
    private static Bottle bottle = new Bottle();

    public static Bottle getInstance() {
        return bottle;
    }

    private Bottle() {
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
        Bottle.COUNT += COUNT;
    }

    @Override
    public String getID() {
        return ID;
    }
}
