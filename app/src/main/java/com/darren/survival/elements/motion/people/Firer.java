package com.darren.survival.elements.motion.people;

import com.darren.survival.elements.model.Good;
import com.darren.survival.elements.model.Motion;
import com.darren.survival.elements.motion.good.Fireable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Darren on 2015/12/11 0011.
 */
public class Firer extends Motion {

    public static int CALORIE = -300;
    public  static int WATER = -9;
    public static int TEMPERATURE = -5;
    public static int VIGOR = -5;
    public static int TIME = -30;

    private static int FIRE_TIME_LEFT;

    private List<Good> KINDLING = new ArrayList<>();//火种
    private List<Good> INFLAMMABLE = new ArrayList<>();//易燃物

    private List<Good> FIREABLES = new ArrayList<>();//可燃物，添加燃料时使用

    private static Firer firer = new Firer();

    public static Firer getInstance() {
        return firer;
    }

    private Firer() {
        FIRE_TIME_LEFT = 0;

        KINDLING.add(Good.lighter);
        KINDLING.add(Good.kindling);
        INFLAMMABLE.add(Good.sawdust);
        INFLAMMABLE.add(Good.hay);

        FIREABLES.add(Good.branch);
        FIREABLES.add(Good.firewood);
    }

    @Override
    public void act() {
       super.act();
    }

    public boolean fire(Good fireable) {
        fireable.setCOUNT(-1);
        setFireTimeLeft(((Fireable)fireable).getFireTime());
        return true;
    }

    public boolean startFire(Good kindling, Good inflammable) {
        act();
        kindling.setCOUNT(-1);
        inflammable.setCOUNT(-1);
        setFireTimeLeft(((Fireable)kindling).getFireTime());
        return true;
    }

    public int getFireTimeLeft() {
        return FIRE_TIME_LEFT;
    }

    public void setFireTimeLeft(int change) {
        FIRE_TIME_LEFT = (FIRE_TIME_LEFT + change) > 0 ? (FIRE_TIME_LEFT + change) : 0;
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

    public List<Good> getKINDLING() {
        return KINDLING;
    }

    public List<Good> getINFLAMMABLE() {
        return INFLAMMABLE;
    }

    public List<Good> getFIREABLES() {
//        FIREABLES.clear();
//        for(Good good : survivor.getBackpack()) {
//            if(good instanceof Fireable) FIREABLES.add(good);
//        }
        return FIREABLES;
    }
}
