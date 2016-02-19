package com.darren.survival.utls;

import com.darren.survival.elements.model.Good;
import com.darren.survival.elements.model.Motion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Darren on 2016/1/8 0008.
 */
public class Recipe {
    private Good target;
    private List<Material> materials = new ArrayList<>();
    private boolean needFire;



    public Recipe(Good target) {
        this.target = target;
    }


    public void addMaterial(Material material) {
        materials.add(material);
    }

    public void setNeedFire(boolean needFire) {
        this.needFire = needFire;
    }

    public Good getTarget() {
        return target;
    }

    public List<Material> getMaterials() {
        return materials;
    }

    public boolean isNeedFire() {
        return needFire;
    }

    public boolean isEnough() {
        for(Material material : materials) {
            if(!material.isEnough()) return false;
        }
        if(needFire && !(Motion.firer.getFireTimeLeft() > 0)) return false;
        return true;
    }
}
