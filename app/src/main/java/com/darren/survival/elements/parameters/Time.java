package com.darren.survival.elements.parameters;

import com.darren.survival.elements.model.Parameter;

/**
 * Created by Darren on 2015/12/7 0007.
 */
public class Time extends Parameter {
    private static final int MIN = 0;
    private static final int MAX = 1399;//23:59
    private int value = 720;//12:00

    public static Time time = new Time();

    private Time() {

    }

    public static Time getInstance() {
        return time;
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
