package com.darren.survival.elements.model;

import com.darren.survival.elements.good.Antelope;
import com.darren.survival.elements.good.Axe;
import com.darren.survival.elements.good.Bait;
import com.darren.survival.elements.good.Boat;
import com.darren.survival.elements.good.Bone;
import com.darren.survival.elements.good.Bottle;
import com.darren.survival.elements.good.Branch;
import com.darren.survival.elements.good.Bug;
import com.darren.survival.elements.good.Cirrus;
import com.darren.survival.elements.good.Clothes;
import com.darren.survival.elements.good.CookedFishMeat;
import com.darren.survival.elements.good.CookedMeat;
import com.darren.survival.elements.good.CookedMouseMeat;
import com.darren.survival.elements.good.CookedRabbiteMeat;
import com.darren.survival.elements.good.CookedSnakeMeat;
import com.darren.survival.elements.good.CookedSquirrelMeat;
import com.darren.survival.elements.good.FishFishFish;
import com.darren.survival.elements.good.FireStick;
import com.darren.survival.elements.good.Firewood;
import com.darren.survival.elements.good.Fish;
import com.darren.survival.elements.good.FishMeat;
import com.darren.survival.elements.good.FoamBoard;
import com.darren.survival.elements.good.FreshFish;
import com.darren.survival.elements.good.FreshFishMeat;
import com.darren.survival.elements.good.FrozenBody;
import com.darren.survival.elements.good.Fur;
import com.darren.survival.elements.good.Gasoline;
import com.darren.survival.elements.good.Hay;
import com.darren.survival.elements.good.Ice;
import com.darren.survival.elements.good.Kindling;
import com.darren.survival.elements.good.Knife;
import com.darren.survival.elements.good.Lighter;
import com.darren.survival.elements.good.Meat;
import com.darren.survival.elements.good.Mouse;
import com.darren.survival.elements.good.MouseMeat;
import com.darren.survival.elements.good.Rabbit;
import com.darren.survival.elements.good.RabbitMeat;
import com.darren.survival.elements.good.Rope;
import com.darren.survival.elements.good.Sawdust;
import com.darren.survival.elements.good.Sewage;
import com.darren.survival.elements.good.Snake;
import com.darren.survival.elements.good.SnakeMeat;
import com.darren.survival.elements.good.Snow;
import com.darren.survival.elements.good.Souvenir;
import com.darren.survival.elements.good.Squirrel;
import com.darren.survival.elements.good.SquirrelMeat;
import com.darren.survival.elements.good.Stick;
import com.darren.survival.elements.good.Stone;
import com.darren.survival.elements.good.TreatedWater;
import com.darren.survival.elements.good.Water;
import com.darren.survival.elements.good.Weapon;
import com.darren.survival.elements.good.Wire;

import java.util.HashMap;
import java.util.Map;

/**
 * 所有物品类的父类
 * Created by Darren on 2015/12/10 0010.
 */
public abstract class Good {
    public static final double WEIGHT = 0;//物品所占质量
    public static int COUNT = 0;//拥有该物品的数量，初始为0
    //物品列表
    public static final Good antelope = Antelope.getInstance();
    public static final Good axe = Axe.getInstance();
    public static final Good bait = Bait.getInstance();
    public static final Good boat = Boat.getInstance();
    public static final Good bone = Bone.getInstance();
    public static final Good bottle = Bottle.getInstance();
    public static final Good branch = Branch.getInstance();
    public static final Good bug = Bug.getInstance();
    public static final Good cirrus = Cirrus.getInstance();
    public static final Good clothes = Clothes.getInstance();
    public static final Good cookedFishMeat = CookedFishMeat.getInstance();
    public static final Good cookedMeat = CookedMeat.getInstance();
    public static final Good cookedMouseMeat = CookedMouseMeat.getInstance();
    public static final Good cookedRabbiteMeat = CookedRabbiteMeat.getInstance();
    public static final Good cookedSnakeMeat = CookedSnakeMeat.getInstance();
    public static final Good cookedSquirrelMeat = CookedSquirrelMeat.getInstance();
    public static final Good fireStick = FireStick.getInstance();
    public static final Good firewood = Firewood.getInstance();
    public static final Good fish = Fish.getInstance();
    public static final Good fishingRod = FishFishFish.getInstance();
    public static final Good fishMeat = FishMeat.getInstance();
    public static final Good foamBoard = FoamBoard.getInstance();
    public static final Good freshFish = FreshFish.getInstance();
    public static final Good freshFishMeat = FreshFishMeat.getInstance();
    public static final Good frozenBody = FrozenBody.getInstance();
    public static final Good fur = Fur.getInstance();
    public static final Good gasoline = Gasoline.getInstance();
    public static final Good hay = Hay.getInstance();
    public static final Good ice = Ice.getInstance();
    public static final Good kindling = Kindling.getInstance();
    public static final Good knife = Knife.getInstance();
    public static final Good lighter = Lighter.getInstance();
    public static final Good meat = Meat.getInstance();
    public static final Good mouse = Mouse.getInstance();
    public static final Good mouseMeat = MouseMeat.getInstance();
    public static final Good rabbit = Rabbit.getInstance();
    public static final Good rabbitMeat = RabbitMeat.getInstance();
    public static final Good rope = Rope.getInstance();
    public static final Good sawdust = Sawdust.getInstance();
    public static final Good sewage = Sewage.getInstance();
    public static final Good snake = Snake.getInstance();
    public static final Good snakeMeat = SnakeMeat.getInstance();
    public static final Good snow = Snow.getInstance();
    public static final Good souvenir = Souvenir.getInstance();
    public static final Good squirrel = Squirrel.getInstance();
    public static final Good squirrelMeat = SquirrelMeat.getInstance();
    public static final Good stick = Stick.getInstance();
    public static final Good stone = Stone.getInstance();
    public static final Good treatedWater = TreatedWater.getInstance();
    public static final Good water = Water.getInstance();
    public static final Good weapon = Weapon.getInstance();
    public static final Good wire = Wire.getInstance();

    /**
     * 初始化goodMap，用于通过物品id找到实例
     */
    private static Map<String, Good> goodMap = new HashMap<>();
    static {
        goodMap.put(antelope.getID(),antelope);
        goodMap.put(axe.getID(),axe);
        goodMap.put(bait.getID(),bait);
        goodMap.put(boat.getID(),boat);
        goodMap.put(bone.getID(),bone);
        goodMap.put(bottle.getID(),bottle);
        goodMap.put(branch.getID(),branch);
        goodMap.put(bug.getID(),bug);
        goodMap.put(cirrus.getID(),cirrus);
        goodMap.put(clothes.getID(),clothes);
        goodMap.put(cookedFishMeat.getID(),cookedFishMeat);
        goodMap.put(cookedMeat.getID(),cookedMeat);
        goodMap.put(cookedMouseMeat.getID(),cookedMouseMeat);
        goodMap.put(cookedRabbiteMeat.getID(),cookedRabbiteMeat);
        goodMap.put(cookedSnakeMeat.getID(),cookedSnakeMeat);
        goodMap.put(cookedSquirrelMeat.getID(),cookedSquirrelMeat);
        goodMap.put(fireStick.getID(),fireStick);
        goodMap.put(firewood.getID(),firewood);
        goodMap.put(fish.getID(),fish);
        goodMap.put(fishingRod.getID(),fishingRod);
        goodMap.put(fishMeat.getID(),fishMeat);
        goodMap.put(foamBoard.getID(),foamBoard);
        goodMap.put(freshFish.getID(),freshFish);
        goodMap.put(freshFishMeat.getID(),freshFishMeat);
        goodMap.put(frozenBody.getID(),frozenBody);
        goodMap.put(fur.getID(),fur);
        goodMap.put(gasoline.getID(),gasoline);
        goodMap.put(hay.getID(),hay);
        goodMap.put(ice.getID(),ice);
        goodMap.put(kindling.getID(),kindling);
        goodMap.put(knife.getID(),knife);
        goodMap.put(lighter.getID(),lighter);
        goodMap.put(meat.getID(),meat);
        goodMap.put(mouse.getID(),mouse);
        goodMap.put(mouseMeat.getID(),mouseMeat);
        goodMap.put(rabbit.getID(),rabbit);
        goodMap.put(rabbitMeat.getID(),rabbitMeat);
        goodMap.put(rope.getID(),rope);
        goodMap.put(sawdust.getID(),sawdust);
        goodMap.put(sewage.getID(),sewage);
        goodMap.put(snake.getID(),snake);
        goodMap.put(snakeMeat.getID(),snakeMeat);
        goodMap.put(snow.getID(),snow);
        goodMap.put(souvenir.getID(),souvenir);
        goodMap.put(squirrel.getID(),squirrel);
        goodMap.put(squirrelMeat.getID(),squirrelMeat);
        goodMap.put(stick.getID(),stick);
        goodMap.put(stone.getID(),stone);
        goodMap.put(treatedWater.getID(),treatedWater);
        goodMap.put(water.getID(),water);
        goodMap.put(weapon.getID(),weapon);
        goodMap.put(wire.getID(),wire);
    }

    /**
     * 通过物品ID找到对应的实例
     * @param ID 打算寻找的物品ID
     * @return 对应的实例
     */
    public static Good findGoodById(String ID) {
        return goodMap.get(ID);
    }

    abstract  public double getWEIGHT();
    abstract public int getCOUNT();
    abstract public void setCOUNT(int COUNT);
    abstract public String getID();

    /**
     * 获取此类用来显示的名字
     * @return 用来显示的名字
     */
    public String getName() {
        String[] strTemp = getClass().getName().split("\\.");
        return strTemp[strTemp.length - 1];
    }
}
