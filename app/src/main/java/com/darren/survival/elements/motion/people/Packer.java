package com.darren.survival.elements.motion.people;

import com.darren.survival.elements.model.Good;
import com.darren.survival.elements.model.Motion;
import com.darren.survival.elements.model.Scene;
import com.darren.survival.utls.RandomUtil;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

    private Map<Good, Integer> newGoods;

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

    public void getGoods(Motion motion, Scene scene) {
        newGoods = new LinkedHashMap<>();
        Map<Good[], Integer[]> goodsMap = scene.getGoods(motion); //根据场景、行为获得物品掉落list
        for(Good[] goodsArray : goodsMap.keySet()) {//遍历掉落list的每种物品数组
            Integer[] goodsInfo = goodsMap.get(goodsArray);//得到该物品数组的详细信息（掉落概率及掉落次数）
            for(int i=0; i<goodsInfo[1]; i++) {//掉落物品，循环次数为掉落次数
               if(RandomUtil.randomHappened(goodsInfo[0])) {//根据掉落概率判断是否掉落
                   Good good = goodsArray[RandomUtil.nextInt(goodsArray.length)];
                   if(!backpack.contains(good)) backpack.add(good);
                   good.addCount(1);
                   newGoods.put(good, newGoods.containsKey(good) ? newGoods.get(good) + 1 : 1);
               }
            }
        }
    }

    public Map<Good, Integer> getNewGoods() {
        return newGoods;
    }
}
