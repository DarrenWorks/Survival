package com.darren.survival.elements.motion.people;

import com.darren.survival.elements.model.Motion;
import com.darren.survival.elements.model.Scene;

/**
 * Created by Darren on 2015/12/11 0011.
 */
public class Hurrier extends Motion {
    int CALORIE = -300;
    int WATER = -9;
    int TEMPERATURE = -5;
    int VIGOR = -5;
    int TIME = -30;

    Scene scene = null;

    private static Hurrier hurrier = new Hurrier();

    public static Hurrier getInstance() {
        return hurrier;
    }

    private Hurrier() {
        super();
        scene = getSurvivor().getScene();
    }

    @Override
    public void act() {
       super.act();
        Motion.firer.setFireTimeLeft(- Motion.firer.getFireTimeLeft());
        scene.setLength(-scene.getSpeed());
        if (scene.getLength() <= 0) {
            scene.initLength();
            scene = getSurvivor().moveToNextScene();
        }
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
