package com.darren.survival.elements.good;

import com.darren.survival.elements.model.Good;
import com.darren.survival.elements.motion.good.Eatable;
import com.darren.survival.elements.motion.good.Makable;

/**
 * Created by Darren on 2015/12/15 0015.
 */
public class Snow extends Good implements Makable, Eatable {
    public static final double WEIGHT = 0.3;
    public static int COUNT = 0;
    public static final String ID = "ET3";
    private static Snow snow = new Snow();

    public static Snow getInstance() {
        return snow;
    }

    private Snow() {
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
        Snow.COUNT += COUNT;
    }

    @Override
    public String getID() {
        return ID;
    }
}
