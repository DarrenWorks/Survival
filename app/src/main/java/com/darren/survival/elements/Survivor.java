package com.darren.survival.elements;

import com.darren.survival.elements.model.Good;
import com.darren.survival.elements.model.Motion;
import com.darren.survival.elements.model.Scene;

/**
 * Created by Darren on 2015/12/7 0007.
 * 初始化和集中处理参数及场景等
 */
public class Survivor {
    private Scene scene;
    private Scene nextScene;


    private static Survivor survivor = new Survivor();

    private Survivor() {
        //初始化场景，生成第一个场景
        scene = Scene.getFirstScene();
        nextScene = scene.getNext();
    }

    public void initData() {

        for(Good good : Motion.packer.getBackpack()) {//将所有数量非0的物品置0
            good.setCount(-good.getCount());
        }
        Motion.packer.getBackpack().clear();


    }

    public static Survivor getInstance() {
        return survivor;
    }

    public Scene getScene() {
        return scene;
    }

    public Scene getNextScene() {

        return nextScene;
    }

    public Scene moveToNextScene() {
        scene = nextScene;
        nextScene = scene.getNext();
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

}
