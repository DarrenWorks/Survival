package com.darren.survival.elements.good;

import com.darren.survival.elements.model.Good;
import com.darren.survival.elements.motion.good.Makable;

/**
 * Created by Darren on 2015/12/15 0015.
 */
public class FrozenBody extends Good implements Makable {
    public static final double WEIGHT = 2;
    public static int COUNT = 0;
    public static final String ID = "WK6";
    private static FrozenBody frozenBody = new FrozenBody();

    public static FrozenBody getInstance() {
        return frozenBody;
    }

    private FrozenBody() {
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
        FrozenBody.COUNT += COUNT;
    }

    @Override
    public String getID() {
        return ID;
    }
}
