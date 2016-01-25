package com.darren.survival.elements.scene;

import com.darren.survival.elements.model.Good;
import com.darren.survival.elements.model.Scene;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Darren on 2015/12/6 0006.
 */
public class Mountain extends Scene {
    //nextScene：可能的下一场景 nextSceneWeight:每个场景可能出现的权重
    public final Map<Scene, Integer> nextScene = new HashMap<>();
    //获得物品相关
    private static final Good[] FOODS = {Good.rabbit};
    private static final Integer[] FOODS_INFO = {30, 3};
    private static final Good[] WOODS = {Good.branch, Good.hay};
    private static final Integer[] WOODS_INFO = {50, 1};
    private static final Good[] BUGS = {Good.bug};
    private static final Integer[] BUGS_INFO = {5, 1};
    private static final Good[] HUMAN_REMAINS = {Good.rope, Good.lighter, Good.wire};
    private static final Integer[] HUMAN_REMAINS_INFO = {5, 1};
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
    public static final String ID = "SC3";
    //单例模式
    private static Mountain mountain = new Mountain();
    //单例模式
    private  Mountain() {
        super();
        speed = 2;
    }
    //单例模式
    public static Mountain getInstance() {
        return mountain;
    }

    public Map<Scene, Integer> getNextScene() {
        if(nextScene.isEmpty()) {
            nextScene.put(Scene.forest, 1);
            nextScene.put(Scene.river, 1);
            nextScene.put(Scene.iceberg, 1);
            nextScene.put(Scene.snowland, 1);
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
        HUNTED_GOODS.put(FOODS, FOODS_INFO);
        TOURED_GOODS.put(WOODS, WOODS_INFO);
        TOURED_GOODS.put(BUGS, BUGS_INFO);
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
