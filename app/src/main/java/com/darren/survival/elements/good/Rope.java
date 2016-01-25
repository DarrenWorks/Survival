package com.darren.survival.elements.good;

import com.darren.survival.elements.model.Good;
import com.darren.survival.elements.motion.good.Makable;

/**
 * Created by Darren on 2015/12/15 0015.
 */
public class Rope extends Good implements Makable {
    public static final double WEIGHT = 0.5;
    public static int COUNT = 0;
    public static final String ID = "WK2";
    private static Rope rope = new Rope();

    public static Rope getInstance() {
        return rope;
    }

    private Rope() {
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
        this.COUNT += COUNT;
    }

    @Override
    public String getID() {
        return ID;
    }
}
