package com.darren.survival.utls;

import com.darren.survival.elements.model.Good;
import com.darren.survival.elements.model.Motion;
import com.darren.survival.elements.model.Scene;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by Darren on 2015/12/6 0006.
 */
public class RandomUtil {
    public static final Random r = new Random();

    public static int nextInt(int n) {
        return r.nextInt(n);
    }

    public static boolean nextBoolean() {
        return r.nextBoolean();
    }

    /**
     * 根据权重随机
     * @param itemMap T为随即项，Integer为该项的权重
     * @param <T> 随机项
     * @return 随机到的对象
     */
    public static <T> T randomByWeight(Map<T, Integer> itemMap) {
        int total = 0;
        for(int i : itemMap.values()) {
            total += i;
        }
        int random = nextInt(total);
        for(Map.Entry<T, Integer> set : itemMap.entrySet()) {
            random -= set.getValue();
            if(random <= 0) return set.getKey();
        }
        return null;
    }

    /**
   * 按照顺序依次传入随机选项及其权重
   * eg:{A,1,B,2,C,1,D,2}
   * 没有进行异常处理 不要尝试传入错误参数
    */
    public static String randomByWeight(String[] items) {
        ArrayList<String> itemList = new ArrayList<>();
        ArrayList<Integer> weightList = new ArrayList<>();
        int total = 0;
        for (int i = 0; i < items.length; i++) {
            if (i % 2 == 0) itemList.add(items[i]);
            else {
                weightList.add(Integer.parseInt(items[i]));
                total += Integer.parseInt(items[i]);
            }
        }

        int number = nextInt(total);
        for (int i = 0; ; i++) {
            number -= weightList.get(i);
            if (number <= 0) return itemList.get(i);
        }
    }
    /**
    *items： 随机选项
    * weight: 每个选项的权重
    * 没有进行异常处理 不要尝试传入错误参数
     */
    public static String randomByWeight(String[] items,int[] weights) {
        int total = 0;
        for(int i=0; i<weights.length; i++) {
            total += weights[i];
        }

        int number = nextInt(total);
        for (int i = 0; ; i++) {
            number -= weights[i];
            if (number <= 0) return items[i];
        }
    }
    /**
    *scene:获取物品的场景
    * good:将要获取的物品
    * time:尝试获取的次数
    * int:返回获取到的数量
     */
    public static List<Good> randomGoods(Scene scene, Motion motion) {
        Map<Good[], Integer[]> goodsMap = scene.getGoods(motion); //根据场景、行为获得物品掉落list
        List<Good> goods = new ArrayList<>();
        for(Good[] goodsArray : goodsMap.keySet()) {//遍历掉落list的每种物品数组
            Integer[] goodsInfo = goodsMap.get(goodsArray);//得到该物品数组的详细信息（掉落概率及掉落次数）
            for(int i=0; i<goodsInfo[1]; i++) {//掉落物品，循环次数为掉落次数
                if(r.nextInt(100) < goodsInfo[0]) {//随机数小于概率判定为掉落成功
                    Good good = goodsArray[r.nextInt(goodsArray.length)];
                    goods.add(good);
                }
            }
        }
        return goods;
    }

    public static boolean randomHappened(int pr) {
        return r.nextInt(100) < pr;
    }

}
