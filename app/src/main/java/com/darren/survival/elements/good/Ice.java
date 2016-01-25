package com.darren.survival.elements.good;

import com.darren.survival.elements.model.Good;
import com.darren.survival.elements.motion.good.Eatable;
import com.darren.survival.elements.motion.good.Makable;

/**
 * Created by Darren on 2015/12/15 0015.
 */
public class Ice extends Good implements Eatable, Makable {
    public static final double WEIGHT = 0.5;
    public static int COUNT = 0;
    public static final int CALORIE = 0;
    public static final int WATER = 10;
    public static final int TEMPERATURE = -30;
    public static final String ID = "ET2";
    private static Ice ice = new Ice();

    public static Ice getInstance() {
        return ice;
    }

    private Ice() {
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
        Ice.COUNT += COUNT;
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
