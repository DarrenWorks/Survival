package com.darren.survival.elements.good;

import com.darren.survival.elements.model.Good;
import com.darren.survival.elements.motion.good.Fireable;
import com.darren.survival.elements.motion.good.Getable;
import com.darren.survival.elements.motion.good.Makable;

/**
 * Created by Darren on 2015/12/10 0010.
 */
public class Branch extends Good implements Fireable, Makable, Getable {
    public static final double WEIGHT = 0.2;
    public static final int FIRE_TIME = 10;
    public static int COUNT = 0;
    public static final String ID = "FR1";

    public static Branch branch = new Branch();

    private Branch(){};

    public static Branch getInstance() {
        return branch;
    }

    @Override
    public double getWEIGHT() {
        return WEIGHT;
    }

    @Override
    public int getFireTime() {
        return FIRE_TIME;
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
