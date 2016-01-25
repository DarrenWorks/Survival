package com.darren.survival.elements.parameters;

import com.darren.survival.elements.model.Parameter;

/**
 * Created by Darren on 2015/12/7 0007.
 */
public class Vigor extends Parameter {
    private static final int MIN = 0;
    private static final int MAX = 100;
    private int value = 100;

    private static Vigor vigor = new Vigor();

    private Vigor() {

    }

    public static Vigor getInstance() {
        return vigor;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public void setValue(int value) {
        this.value = value;
    }
}
