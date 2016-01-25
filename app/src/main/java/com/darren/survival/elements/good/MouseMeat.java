package com.darren.survival.elements.good;

import com.darren.survival.elements.model.Good;
import com.darren.survival.elements.motion.good.Eatable;
import com.darren.survival.elements.motion.good.Makable;

/**
 * Created by Darren on 2015/12/15 0015.
 */
public class MouseMeat extends Good implements Makable, Eatable {
    public static final double WEIGHT = 0.1;
    public static int COUNT = 0;
    public static final String ID = "ET16";
    private static MouseMeat mouseMeat = new MouseMeat();

    public static MouseMeat getInstance() {
        return mouseMeat;
    }

    private MouseMeat() {
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
        MouseMeat.COUNT += COUNT;
    }

    @Override
    public String getID() {
        return ID;
    }
}
