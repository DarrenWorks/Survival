package com.darren.survival.elements.good;

import com.darren.survival.elements.model.Good;
import com.darren.survival.elements.motion.good.Huntable;

/**
 * Created by Darren on 2015/12/15 0015.
 */
public class Bait extends Good implements Huntable {
    public static final double WEIGHT = 0.01;
    public static int COUNT = 0;
    public static final String ID = "HT2";
    private static Bait bait = new Bait();

    public static Bait getInstance() {
        return bait;
    }

    private Bait() {
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
        Bait.COUNT += COUNT;
    }

    @Override
    public String getID() {
        return ID;
    }
}
