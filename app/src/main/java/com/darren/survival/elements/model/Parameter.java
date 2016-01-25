package com.darren.survival.elements.model;

import com.darren.survival.elements.parameters.Calorie;
import com.darren.survival.elements.parameters.Temperature;
import com.darren.survival.elements.parameters.Time;
import com.darren.survival.elements.parameters.Vigor;
import com.darren.survival.elements.parameters.Water;

/**
 * 所有属性类的父类
 * Created by Darren on 2015/12/5 0005.
 */
public abstract class Parameter {
    //属性列表
    public static final Parameter calorie = Calorie.getInstance();
    public static final Parameter temperature = Temperature.getInstance();
    public static final Parameter time = Time.getInstance();
    public static final Parameter vigor = Vigor.getInstance();
    public static final Parameter water = Water.getInstance();

    /**
     * 获取此类用来显示的名字
     * @return 用来显示的名字
     */
    public String getName() {
        String[] strTemp = getClass().getName().split("\\.");
        return strTemp[strTemp.length - 1];
    }

    /**
     * 改变属性的值
     * @param value 该属性将要增加的数值（正为加，负为减）
     */
    public void change(int value) {
        setValue(getValue() + value);
    }

    abstract public int getValue();
    abstract public void setValue(int value);
}
