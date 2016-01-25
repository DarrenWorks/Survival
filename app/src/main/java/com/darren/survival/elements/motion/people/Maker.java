package com.darren.survival.elements.motion.people;

import com.darren.survival.elements.model.Motion;

/**
 * Created by Darren on 2015/12/11 0011.
 */
public class Maker extends Motion {
    public static int CALORIE = -300;
    public static int WATER = -9;
    public static int TEMPERATURE = -5;
    public static int VIGOR = -5;
    public static int TIME = -30;

    private static Maker ourInstance = new Maker();

    public static Maker getInstance() {
        return ourInstance;
    }

    private Maker() {
        super();
    }

    @Override
    public void act() {
        super.act();
    }

    @Override
    public int getCALORIE() {
        return CALORIE;
    }

    @Override
    public int getWATER() {
        return WATER;
    }

    @Override
    public int getTEMPERATURE() {
        return TEMPERATURE;
    }

    @Override
    public int getVIGOR() {
        return VIGOR;
    }

    @Override
    public int getTIME() {
        return TIME;
    }
}
