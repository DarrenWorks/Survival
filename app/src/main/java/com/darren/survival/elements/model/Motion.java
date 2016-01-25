package com.darren.survival.elements.model;

import com.darren.survival.elements.Survivor;
import com.darren.survival.elements.motion.people.Camper;
import com.darren.survival.elements.motion.people.Firer;
import com.darren.survival.elements.motion.people.Hunter;
import com.darren.survival.elements.motion.people.Hurrier;
import com.darren.survival.elements.motion.people.Maker;
import com.darren.survival.elements.motion.people.Packer;
import com.darren.survival.elements.motion.people.Restor;
import com.darren.survival.elements.motion.people.Tourer;

/**
 * 所有行为类的父类
 * Created by Darren on 2015/12/5 0005.
 */
public abstract class Motion {
    private Survivor survivor = Survivor.getInstance();
    //行为列表
    public static final Camper camper = Camper.getInstance();
    public static final Firer firer = Firer.getInstance();
    public static final Hunter hunter = Hunter.getInstance();
    public static final Hurrier hurrier = Hurrier.getInstance();
    public static final Maker maker = Maker.getInstance();
    public static final Packer packer = Packer.getInstance();
    public static final Restor restor = Restor.getInstance();
    public static final Tourer tourer = Tourer.getInstance();

    protected Survivor getSurvivor() {
        return survivor;
    }

    /**
     * 进行动作的实现，进行parameters值的变化等
     */
    public void act() {
        Parameter.calorie.change(getCALORIE());
        Parameter.water.change(getWATER());
        Parameter.temperature.change(getTEMPERATURE());
        Parameter.vigor.change(getVIGOR());
        Parameter.time.change(getTIME());
    }

    abstract public int getCALORIE();
    abstract public int getWATER();
    abstract public int getTEMPERATURE();
    abstract public int getVIGOR();
    abstract public int getTIME();

    /**
     * 获取此类用来显示的名字
     * @return 用来显示的名字
     */
    public String getName() {
        String[] strTemp = getClass().getName().split("\\.");
        return strTemp[strTemp.length - 1];
    }
}
