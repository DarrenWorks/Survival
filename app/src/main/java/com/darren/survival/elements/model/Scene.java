package com.darren.survival.elements.model;

import com.darren.survival.elements.motion.people.Hunter;
import com.darren.survival.elements.motion.people.Tourer;
import com.darren.survival.elements.scene.Forest;
import com.darren.survival.elements.scene.Iceberg;
import com.darren.survival.elements.scene.Jungle;
import com.darren.survival.elements.scene.Lake;
import com.darren.survival.elements.scene.Mountain;
import com.darren.survival.elements.scene.Plains;
import com.darren.survival.elements.scene.River;
import com.darren.survival.elements.scene.Snowland;
import com.darren.survival.utls.RandomUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * 所有场景类的父类
 * Created by Darren on 2015/12/6 0006.
 */
public abstract class Scene {
    //场景列表
    public static final Scene forest = Forest.getInstance();
    public static final Scene iceberg = Iceberg.getInstance();
    public static final Scene jungle = Jungle.getInstance();
    public static final Scene lake = Lake.getInstance();
    public static final Scene mountain = Mountain.getInstance();
    public static final Scene plains = Plains.getInstance();
    public static final Scene river = River.getInstance();
    public static final Scene snowland = Snowland.getInstance();
    //场景类的路径，用来根据String获得实例
    public static final String packagePath = "com.darren.survival.elements.scene.";
    //终点的概率
    public static final int PROBABLITY1_3 = 0;
    public static final int PROBABLITY4_5 = 10;
    public static final int PROBABLITY6_9 = 30;
    public static final int PROBABLITY10 = 50;
    public static final int PROBABLITY11 = 70;
    public static final int PROBABLITY12 = 100;
    //可能的下一场景及每个场景可能出现的权重
    public final static Map<Scene, Integer> nextScene = new HashMap<>();
    //场景类名字，用来重载
    public static final String Type = null;
    //此场景的下一场景是否可能为终点场景，用来重载
    public final String CanBEnd = "none";
    //此场景的最小及最大长度
    private static final int minLength = 0;
    private static final int maxLength = 0;
    //初始化此场景时随机长度，用来重载
    private int length;
    //记录已经到达的场景数
    public static int count = 0;
    //此场景的移动速度
    private int speed;
    /**
     * 初始化sceneMap，用于通过物品id找到实例
     */
    private static Map<String, Scene> sceneMap = new HashMap<>();
    static {
        sceneMap.put(forest.getID(), forest);
        sceneMap.put(iceberg.getID(), iceberg);
        sceneMap.put(jungle.getID(), jungle);
        sceneMap.put(lake.getID(), lake);
        sceneMap.put(mountain.getID(), mountain);
        sceneMap.put(plains.getID(), plains);
        sceneMap.put(river.getID(), river);
        sceneMap.put(snowland.getID(), snowland);
    }

    /**
     * 通过场景ID找到对应的实例
     * @param ID 打算寻找的场景ID
     * @return 对应的实例
     */
    public static Scene findGoodById(String ID) {
        return sceneMap.get(ID);
    }

    protected Scene() {
        initLength();
        initGoods();
    }

    public static Scene getFirstScene() {
        count++;//到达的场景数加1
        if(nextScene.isEmpty()) {
            nextScene.put(Scene.forest, 1);
            nextScene.put(Scene.plains, 1);
            nextScene.put(Scene.mountain, 1);
            nextScene.put(Scene.river, 1);
            nextScene.put(Scene.iceberg, 1);
            nextScene.put(Scene.snowland, 1);
            nextScene.put(Scene.jungle, 1);
            nextScene.put(Scene.lake, 1);
        }
        return RandomUtil.randomByWeight(nextScene);//随机下一个到达的场景
    }
    //下一随机场景
    public Scene getNext() {
        count++;//到达的场景数加1
        return RandomUtil.randomByWeight(getNextScene());//随机下一个到达的场景
    }

    public void initLength() {
        int length = getMinLength() + RandomUtil.nextInt(getMaxLength() - getMinLength());
        setLength(length - getLength());
    }

    abstract public Map<Scene, Integer> getNextScene();
    abstract public int getLength();
    abstract public void setLength(int length);
    abstract public int getSpeed();
    abstract public String getID();
    abstract protected int getMinLength();
    abstract protected int getMaxLength();
    /**
     * 初始化一些行为可以获得的物品
     */
    abstract protected void initGoods();
    abstract public Map<Good[], Integer[]> getHuntedGoods();
    abstract public Map<Good[], Integer[]> getTouredGoods();

    /**
     * 根据motion的类型返回对应的物品列表
     * @param motion 用来判断motion的类型
     * @return 返回对应的物品列表
     */
    public Map<Good[], Integer[]> getGoods(Motion motion) {
        if(motion instanceof Hunter) return getHuntedGoods();
        if(motion instanceof Tourer) return getTouredGoods();
        return null;
    }

    /**
     * 获取此类用来显示的名字
     * @return 用来显示的名字
     */
    public String getName() {
        String[] strTemp = getClass().getName().split("\\.");
        return strTemp[strTemp.length - 1];
    }
}
