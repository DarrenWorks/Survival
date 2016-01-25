package com.darren.survival.elements.good;

import com.darren.survival.elements.model.Good;
import com.darren.survival.elements.motion.good.Makable;

/**
 * Created by Darren on 2015/12/15 0015.
 */
public class Bone extends Good implements Makable {
    public static final double WEIGHT = 0.2;
    public static int COUNT = 0;
    public static final String ID = "WK17";
    private static Bone bone = new Bone();

    public static Bone getInstance() {
        return bone;
    }

    private Bone() {
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
        Bone.COUNT += COUNT;
    }

    @Override
    public String getID() {
        return ID;
    }
}
