package com.darren.survival.utls;

import com.darren.survival.elements.model.Good;

/**
 * Created by Darren on 2016/1/11 0011.
 */
public class Material {
    private Good[] material;
    private int amount;

    /**
     *
     * @param amount 此材料的消耗数量
     * @param material 此材料可以是哪几种物品
     */
    public Material(int amount, Good... material) {
        this.material = material;
        this.amount = amount;
    }

    public Good[] getMaterial() {
        return material;
    }

    public int getAmount() {
        return amount;
    }
}
