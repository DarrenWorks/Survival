package com.darren.survival.elements.scene;

import com.darren.survival.elements.model.Good;
import com.darren.survival.elements.model.Scene;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Darren on 2015/12/6 0006.
 */
public class Forest extends Scene {
    //nextScene：可能的下一场景 nextSceneWeight:每个场景可能出现的权重
    public final Map<Scene, Integer> nextScene = new HashMap<>();
    //获得物品相关
    private static final Good[] FOODS = {Good.rabbit, Good.squirrel, Good.snake};
    private static final Integer[] FOODS_INFO = {15, 6};
    private static final Good[] WOODS = {Good.branch,Good.firewood, Good.sawdust};
    private static final Integer[] WOODS_INFO = {70, 2};
    private static final Good[] BUGS = {Good.bug};
    private static final Integer[] BUGS_INFO = {30, 1};
    private static final Good[] HUMAN_REMAINS = {Good.rope, Good.lighter, Good.wire};
    private static final Integer[] HUMAN_REMAINS_INFO = {5, 1};
    private static final Good[] CIRRUS = {Good.cirrus};
    private static final Integer[] CIRRUS_INFO = {10, 1};
    private static final Good[] STONE = {Good.stone};
    private static final Integer[] STONE_INFO = {70, 1};
    private static final Map<Good[], Integer[]> HUNTED_GOODS = new HashMap<>();
    private static final Map<Good[], Integer[]> TOURED_GOODS = new HashMap<>();
    //此场景的最小及最大长度
    private static final int minLength = 20;
    private static final int maxLength = 30;
    //初始化此场景时随机长度
    private int length;
    //此场景的移动速度
    private int speed;
    public static final String ID = "SC1";
    //单例模式
    private static Forest forest = new Forest();

    //单例模式
    private Forest() {
        super();
        speed = 2;
    }


    //单例模式
    public static Forest getInstance() {
        return forest;
    }

    public Map<Scene, Integer> getNextScene() {
        if(nextScene.isEmpty()) {
            nextScene.put(Scene.plains, 1);
            nextScene.put(Scene.mountain, 1);
            nextScene.put(Scene.river, 1);
            nextScene.put(Scene.jungle, 1);
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
        TOURED_GOODS.put(CIRRUS, CIRRUS_INFO);
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
