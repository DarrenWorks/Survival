package com.darren.survival.elements.good;

import com.darren.survival.elements.model.Good;
import com.darren.survival.elements.motion.good.Huntable;

/**
 * Created by Darren on 2015/12/15 0015.
 */
public class FishFishFish extends Good implements Huntable {
    public static final double WEIGHT = 2;
    public static int COUNT = 0;
    public static final String ID = "HT3";
    public int test = 0;
    private static FishFishFish fishingRod = new FishFishFish();

    public static FishFishFish getInstance() {
        return fishingRod;
    }

    private FishFishFish() {
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
        FishFishFish.COUNT += COUNT;
    }

    @Override
    public String getID() {
        return ID;
    }
}
