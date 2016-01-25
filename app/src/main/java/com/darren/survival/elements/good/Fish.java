package com.darren.survival.elements.good;

import com.darren.survival.elements.model.Good;
import com.darren.survival.elements.motion.good.Makable;

/**
 * Created by Darren on 2015/12/15 0015.
 */
public class Fish extends Good implements Makable {
    public static final double WEIGHT = 0.3;
    public static int COUNT = 0;
    public static final String ID = "WK10";
    private static Fish fish = new Fish();

    public static Fish getInstance() {
        return fish;
    }

    private Fish() {
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
        Fish.COUNT += COUNT;
    }

    @Override
    public String getID() {
        return ID;
    }
}
