package com.darren.survival.elements.motion.people;

import com.darren.survival.elements.model.Motion;

/**
 * Created by Darren on 2015/12/11 0011.
 */
public class Restor extends Motion {
    public static int CALORIE = -100;
    public static int WATER = -5;
    public static int TEMPERATURE = -15;
    public static int VIGOR = 5;
    public static int TIME = 120;

    public static Restor restor = new Restor();

    private Restor() {
        super();
    }

    public static Restor getInstance() {
        return restor;
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
