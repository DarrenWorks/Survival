package com.darren.survival.elements.good;

import com.darren.survival.elements.model.Good;
import com.darren.survival.elements.motion.good.Makable;

/**
 * Created by Darren on 2015/12/15 0015.
 */
public class FoamBoard extends Good implements Makable {
    public static final double WEIGHT = 2;
    public static int COUNT = 0;
    public static final String ID = "WK5";
    private static FoamBoard foamBoard = new FoamBoard();

    public static FoamBoard getInstance() {
        return foamBoard;
    }

    private FoamBoard() {
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
        FoamBoard.COUNT += COUNT;
    }

    @Override
    public String getID() {
        return ID;
    }
}
