package com.darren.survival.elements.good;

import com.darren.survival.elements.model.Good;
import com.darren.survival.elements.motion.good.Makable;

/**
 * Created by Darren on 2015/12/15 0015.
 */
public class Axe extends Good implements Makable {
    public static final double WEIGHT = 1;
    public static int COUNT = 0;
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
    public int getCOUNT() {
        return COUNT;
    }

    @Override
    public void setCOUNT(int COUNT) {
        Axe.COUNT += COUNT;
    }

    @Override
    public String getID() {
        return ID;
    }
}
