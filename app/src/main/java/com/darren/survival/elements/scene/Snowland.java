package com.darren.survival.elements.scene;

import com.darren.survival.elements.model.Good;
import com.darren.survival.elements.model.Scene;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Darren on 2015/12/6 0006.
 */
public class Snowland extends Scene {
    //nextScene：可能的下一场景 nextSceneWeight:每个场景可能出现的权重
    public final Map<Scene, Integer> nextScene = new HashMap<>();
    //获得物品相关
    private static final Good[] RABBIT = {Good.rabbit};
    private static final Integer[] RABBIT_INFO = {20, 3};
    private static final Good[] ANTELOPE = {Good.antelope};
    private static final Integer[] ANTELOPE_INFO = {5, 1};
    private static final Good[] SNOW = {Good.snow};
    private static final Integer[] SNOW_INFO = {100, 1};
    private static final Good[] FROZEN_BODY = {Good.frozenBody};
    private static final Integer[] FROZEN_BODY_INFO = {5, 1};
    private static final Good[] WOODS = {Good.branch, Good.firewood};
    private static final Integer[] WOODS_INFO = {10, 1};
    private static final Good[] STONE = {Good.stone};
    private static final Integer[] STONE_INFO = {50, 1};
    private static final Map<Good[], Integer[]> HUNTED_GOODS = new HashMap<>();
    private static final Map<Good[], Integer[]> TOURED_GOODS = new HashMap<>();
    //此场景的最小及最大长度
    private static final int minLength = 20;
    private static final int maxLength = 30;
    //初始化此场景时随机长度
    private int length;
    //此场景的移动速度
    private int speed;
    public static final String ID = "SC6";
    //单例模式
    private static Snowland snowland = new Snowland();

    //单例模式
    private Snowland() {
        super();
        speed = 2;
    }

    //单例模式
    public static Snowland getInstance() {
        return snowland;
    }

    public Map<Scene, Integer> getNextScene() {
        if(nextScene.isEmpty()) {
            nextScene.put(Scene.mountain, 1);
            nextScene.put(Scene.river, 1);
            nextScene.put(Scene.jungle, 1);
        }
        return nextScene;
    }

    @Override
    protected int getMinLength() {
        return minLength;
    }

    @Override
    protected int getMaxLength() {
        return maxLength;
    }


    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length += length;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public String getID() {
        return ID;
    }

    @Override
    protected void initGoods() {
        HUNTED_GOODS.put(RABBIT, RABBIT_INFO);
        HUNTED_GOODS.put(ANTELOPE, ANTELOPE_INFO);
        TOURED_GOODS.put(SNOW, SNOW_INFO);
        TOURED_GOODS.put(FROZEN_BODY, FROZEN_BODY_INFO);
        TOURED_GOODS.put(WOODS, WOODS_INFO);
        TOURED_GOODS.put(STONE, STONE_INFO);
    }

    @Override
    public Map<Good[], Integer[]> getHuntedGoods() {
        return HUNTED_GOODS;
    }

    @Override
    public Map<Good[], Integer[]> getTouredGoods() {
        return TOURED_GOODS;
    }
}
