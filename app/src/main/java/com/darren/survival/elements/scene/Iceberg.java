package com.darren.survival.elements.scene;

import com.darren.survival.elements.model.Good;
import com.darren.survival.elements.model.Scene;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Darren on 2015/12/6 0006.
 */
public class Iceberg extends Scene {
    //nextScene：可能的下一场景 nextSceneWeight:每个场景可能出现的权重
    public final Map<Scene, Integer> nextScene = new HashMap<>();
    //获得物品相关
    private static final Good[] ICE = {Good.ice};
    private static final Integer[] ICE_INFO = {100, 1};
    private static final Good[] FROZEN_BODY = {Good.frozenBody};
    private static final Integer[] FROZEN_BODY_INFO = {5, 1};
    private static final Good[] WOODS = {Good.branch, Good.firewood};
    private static final Integer[] WOODS_INFO = {10, 1};
    private static final Good[] STONE = {Good.stone};
    private static final Integer[] STONE_INFO = {30, 1};
    private static final Map<Good[], Integer[]> HUNTED_GOODS = new HashMap<>();
    private static final Map<Good[], Integer[]> TOURED_GOODS = new HashMap<>();
    //此场景的最小及最大长度
    private static final int minLength = 10;
    private static final int maxLength = 20;
    //初始化此场景时随机长度
    private int length;
    //此场景的移动速度
    private int speed;
    public static final String ID = "SC5";
    //单例模式
    private static Iceberg iceberg = new Iceberg();

    //单例模式
    private Iceberg() {
        super();
        speed = 2;
    }

    //单例模式
    public static Iceberg getInstance() {
        return iceberg;
    }

    public Map<Scene, Integer> getNextScene() {
        if(nextScene.isEmpty()) {
            nextScene.put(Scene.mountain, 1);
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
        TOURED_GOODS.put(ICE, ICE_INFO);
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
