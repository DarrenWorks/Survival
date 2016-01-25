package com.darren.survival.elements.motion.people;

import com.darren.survival.elements.model.Good;
import com.darren.survival.elements.model.Motion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Darren on 2015/12/11 0011.
 */
public class Packer extends Motion {
    public static int CALORIE = -300;
    public  static int WATER = -9;
    public static int TEMPERATURE = -5;
    public static int VIGOR = -5;
    public static int TIME = -30;

    private List<Good> backpack = new ArrayList<>();

    private static Packer packer = new Packer();

    public static Packer getInstance() {
        return packer;
    }

    private Packer() {
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

    public List<Good> getBackpack() {
        return backpack;
    }

}
