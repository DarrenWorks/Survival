package com.darren.survival.elements;

import com.darren.survival.elements.model.Good;
import com.darren.survival.elements.model.Scene;

import java.util.ArrayList;
import java.util.List;

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
