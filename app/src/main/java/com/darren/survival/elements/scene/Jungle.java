package com.darren.survival.elements.scene;

import com.darren.survival.elements.good.Branch;
import com.darren.survival.elements.good.Cirrus;
import com.darren.survival.elements.good.Lighter;
import com.darren.survival.elements.good.Mouse;
import com.darren.survival.elements.good.Rabbit;
import com.darren.survival.elements.good.Rope;
import com.darren.survival.elements.good.Sawdust;
import com.darren.survival.elements.good.Snake;
import com.darren.survival.elements.good.Squirrel;
import com.darren.survival.elements.good.Stone;
import com.darren.survival.elements.good.TreatedWater;
import com.darren.survival.elements.good.Water;
import com.darren.survival.elements.good.Wire;
import com.darren.survival.elements.model.Good;
import com.darren.survival.elements.model.Scene;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Darren on 2015/12/6 0006.
 */
public class Jungle extends Scene {
    //nextScene：可能的下一场景 nextSceneWeight:每个场景可能出现的权重
    public final Map<Scene, Integer> nextScene = new HashMap<>();
    //获得物品相关
    private static final Good[] BUGS = {Good.bug};
    private static final Integer[] BUGS_INFO = {60, 3};
    private static final Good[] FOODS = {Squirrel.getInstance(), Rabbit.getInstance(), Mouse.getInstance(), Snake.getInstance()};
    private static final Integer[] FOODS_INFO = {30, 3};
    private static final Good[] TREATED_WATER = {TreatedWater.getInstance()};
    private static final Integer[] TREATED_WATER_INFO = {90, 1};
    private static final Good[] WATER = {Water.getInstance()};
    private static final Integer[] WATER_INFO = {10, 1};
    private static final Good[] BRANCH = {Branch.getInstance()};
    private static final Integer[] BRANCH_INFO = {10, 1};
    private static final Good[] SAWDUST = {Sawdust.getInstance()};
    private static final Integer[] SAWDUST_INFO = {5, 1};
    private static final Good[] CIRRUS = {Cirrus.getInstance()};
    private static final Integer[] CIRRUS_INFO = {70, 1};
    private static final Good[] HUMAN_REMAINS = {Rope.getInstance(), Lighter.getInstance(), Wire.getInstance()};
    private static final Integer[] HUMAN_REMAINS_INFO = {10, 1};
    private static final Good[] STONE = {Stone.getInstance()};
    private static final Integer[] STONE_INFO = {70, 1};
    private static final Map<Good[], Integer[]> HUNTED_GOODS = new HashMap<>();
    private static final Map<Good[], Integer[]> TOURED_GOODS = new HashMap<>();
    //此场景的最小及最大长度
    private static final int minLength = 20;
    private static final int maxLength = 40;
    //初始化此场景时随机长度
    private int length;
    //此场景的移动速度
    private int speed;
    public static final String ID = "SC7";
    //单例模式
    private static Jungle jungle = new Jungle();

    //单例模式
    private Jungle() {
        super();
        speed = 2;
    }

    //单例模式
    public static Jungle getInstance() {
        return jungle;
    }

    public Map<Scene, Integer> getNextScene() {
        if(nextScene.isEmpty()) {
            nextScene.put(Scene.forest, 1);
            nextScene.put(Scene.plains, 1);
            nextScene.put(Scene.river, 1);
            nextScene.put(Scene.lake, 1);
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

    public String getCanBEnd() {
        return CanBEnd;
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
        HUNTED_GOODS.put(BUGS, BUGS_INFO);
        HUNTED_GOODS.put(FOODS, FOODS_INFO);
        TOURED_GOODS.put(TREATED_WATER, TREATED_WATER_INFO);
        TOURED_GOODS.put(WATER, WATER_INFO);
        TOURED_GOODS.put(BRANCH, BRANCH_INFO);
        TOURED_GOODS.put(SAWDUST, SAWDUST_INFO);
        TOURED_GOODS.put(CIRRUS, CIRRUS_INFO);
        TOURED_GOODS.put(HUMAN_REMAINS, HUMAN_REMAINS_INFO);
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
