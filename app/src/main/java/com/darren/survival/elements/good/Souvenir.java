package com.darren.survival.elements.good;

import com.darren.survival.elements.model.Good;

/**
 * Created by Darren on 2015/12/15 0015.
 */
public class Souvenir extends Good {
    public static final double WEIGHT = 0;
    private int count = 0;
    public static final String ID = "WK21";
    private static Souvenir souvenir = new Souvenir();

    public static Souvenir getInstance() {
        return souvenir;
    }

    private Souvenir() {
    }

    @Override
    public double getWEIGHT() {
        return WEIGHT;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String getID() {
        return ID;
    }
}
