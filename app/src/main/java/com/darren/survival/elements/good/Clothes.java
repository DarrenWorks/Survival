package com.darren.survival.elements.good;

import com.darren.survival.elements.model.Good;

/**
 * Created by Darren on 2015/12/15 0015.
 */
public class Clothes extends Good {
    public static final double WEIGHT = 2;
    public static int COUNT = 0;
    public static final String ID = "WK20";
    private static Clothes clothes = new Clothes();

    public static Clothes getInstance() {
        return clothes;
    }

    private Clothes() {
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
        Clothes.COUNT += COUNT;
    }

    @Override
    public String getID() {
        return ID;
    }
}
