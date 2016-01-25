package com.darren.survival.elements.good;

import com.darren.survival.elements.model.Good;
import com.darren.survival.elements.motion.good.Makable;

/**
 * Created by Darren on 2015/12/15 0015.
 */
public class Rabbit extends Good implements Makable {
    public static final double WEIGHT = 1;
    public static int COUNT = 0;
    public static final String ID = "WK11";
    private static Rabbit ourInstance = new Rabbit();

    public static Rabbit getInstance() {
        return ourInstance;
    }

    private Rabbit() {
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
        Rabbit.COUNT += COUNT;
    }

    @Override
    public String getID() {
        return ID;
    }
}
