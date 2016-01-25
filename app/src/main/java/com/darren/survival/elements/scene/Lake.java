package com.darren.survival.elements.scene;

import com.darren.survival.elements.model.Good;
import com.darren.survival.elements.model.Scene;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Darren on 2015/12/6 0006.
 */
public class Lake extends Scene {
    //nextScene：可能的下一场景 nextSceneWeight:每个场景可能出现的权重
    public final Map<Scene, Integer> nextScene = new HashMap<>();
    //获得物品相关
    private static final Good[] FISH = {Good.fish};
    private static final Integer[] FISH_INFO = {30, 4};
    private static final Good[] WATER = {Good.water};
    private static final Integer[] WATER_INFO = {99, 1};
    private static final Good[] FRESH_FISH = {Good.freshFish};
    private static final Integer[] FRESH_FISH_INFO = {3, 1};
    private static final Good[] WOODS = {Good.branch, Good.firewood, Good.sawdust};
    private static final Integer[] WOODS_INFO = {20, 1};
    private static final Good[] STONE = {Good.stone};
    private static final Integer[] STONE_INFO = {70, 1};
    private static final Map<Good[], Integer[]> HUNTED_GOODS = new HashMap<>();
    private static final Map<Good[], Integer[]> TOURED_GOODS = new HashMap<>();
    //此场景的最小及最大长度
    private static final int minLength = 10;
    private static final int maxLength = 20;
    //初始化此场景时随机长度
    private int length;
    //此场景的移动速度
    private int speed;
    public static final String ID = "SC8";
    //单例模式
    private static Lake lake = new Lake();

    //单例模式
    private Lake() {
        super();
        speed = 2;
    }

    //单例模式
    public static Lake getInstance() {
        return lake;
    }

    public Map<Scene, Integer> getNextScene() {
        if(nextScene.isEmpty()) {
            nextScene.put(Scene.plains, 1);
            nextScene.put(Scene.river, 1);
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
        HUNTED_GOODS.put(FISH, FISH_INFO);
        TOURED_GOODS.put(WATER, WATER_INFO);
        TOURED_GOODS.put(FRESH_FISH, FRESH_FISH_INFO);
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
