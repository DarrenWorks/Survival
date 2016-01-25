package com.darren.survival.elements.good;

import com.darren.survival.elements.model.Good;
import com.darren.survival.elements.motion.good.Eatable;

/**
 * Created by Darren on 2015/12/15 0015.
 */
public class Water extends Good implements Eatable {
    public static final double WEIGHT = 0.5;
    public static int COUNT = 0;
    public static final int CALORIE = 0;
    public static final int WATER = 20;
    public static final int TEMPERATURE = 0;
    public static final String ID = "ET1";
    private static Water water = new Water();

    public static Water getInstance() {
        return water;
    }

    private Water() {
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
        Water.COUNT += COUNT;
    }

    @Override
    public String getID() {
        return ID;
    }

    public int getCALORIE() {
        return CALORIE;
    }

    public int getWATER() {
        return WATER;
    }

    public int getTEMPERATURE() {
        return TEMPERATURE;
    }
}
