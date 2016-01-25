package com.darren.survival.elements.parameters;

import com.darren.survival.elements.model.Parameter;

/**
 * Created by Darren on 2015/12/5 0005.
 */
public class Calorie extends Parameter {
    private static final int MIN = 0;
    private static final int MAX = 3000;
    private int value = 2000;

    public static Calorie calorie = new Calorie();

    private Calorie() {

    }

    public static Calorie getInstance() {
        return calorie;
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
