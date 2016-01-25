package com.darren.survival.utls;

import com.darren.survival.elements.model.Good;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Darren on 2016/1/4 0004.
 */
public class CraftingManager {
    private Map<String, Recipe> recipeMap = new HashMap<>();
    private static CraftingManager craftingManager = new CraftingManager();


    public static CraftingManager getInstance() {
        return craftingManager;
    }

    private CraftingManager() {
        init();
    }

    private void init() {
        addRecipe(Good.water, true, new Material(1, Good.treatedWater, Good.ice, Good.snow), new Material(0, Good.bottle));
        addRecipe(Good.freshFishMeat, false, new Material(1,Good.freshFish), new Material(0, Good.knife));
        addRecipe(Good.fishMeat, false, new Material(1, Good.fish), new Material(0, Good.knife));
        addRecipe(Good.cookedFishMeat, true, new Material(1, Good.fishMeat));
        addRecipe(Good.rabbitMeat, false, new Material(1, Good.rabbit), new Material(0, Good.knife));
        addRecipe(Good.cookedRabbiteMeat, true, new Material(1, Good.rabbitMeat));
        addRecipe(Good.squirrelMeat, false,new Material(1, Good.squirrel), new Material(0, Good.knife));
        addRecipe(Good.cookedSquirrelMeat, true, new Material(1, Good.squirrelMeat));
        addRecipe(Good.meat, false, new Material(1, Good.antelope, Good.frozenBody), new Material(0, Good.axe), new Material(0, Good.knife));
        addRecipe(Good.cookedMeat, true, new Material(1, Good.meat));
        addRecipe(Good.snakeMeat, false, new Material(1, Good.snake), new Material(0, Good.knife));
        addRecipe(Good.cookedSnakeMeat, true, new Material(1, Good.snakeMeat));
        addRecipe(Good.mouseMeat, false, new Material(1, Good.mouse), new Material(0, Good.knife));
        addRecipe(Good.cookedMouseMeat, true, new Material(1, Good.mouseMeat));
        addRecipe(Good.kindling, false, new Material(1, Good.branch), new Material(1, Good.firewood));
        addRecipe(Good.fireStick, false, new Material(1, Good.bone), new Material(1, Good.gasoline), new Material(1, Good.kindling));
        addRecipe(Good.bait, false, new Material(1, Good.rabbit, Good.squirrel, Good.mouse, Good.frozenBody, Good.fish, Good.freshFish), new Material(0, Good.knife));
        addRecipe(Good.fishingRod, false, new Material(1, Good.branch), new Material(1, Good.rope), new Material(1, Good.wire));
        addRecipe(Good.weapon, false, new Material(1, Good.knife), new Material(1, Good.firewood), new Material(1, Good.rope, Good.cirrus));
        addRecipe(Good.knife, false, new Material(2, Good.stone));
        addRecipe(Good.axe, false, new Material(1, Good.knife), new Material(1, Good.firewood), new Material(1, Good.rope));
        addRecipe(Good.stick, false, new Material(3, Good.branch), new Material(1, Good.rope, Good.cirrus));
        addRecipe(Good.bone, false, new Material(1, Good.rabbit, Good.squirrel, Good.mouse, Good.snake, Good.frozenBody), new Material(1, Good.knife));
        addRecipe(Good.fur, false, new Material(1, Good.antelope), new Material(0, Good.axe), new Material(0, Good.knife));
        addRecipe(Good.boat, false, new Material(3, Good.foamBoard), new Material(4, Good.branch), new Material(1, Good.rope, Good.cirrus));
        addRecipe(Good.clothes, false, new Material(1, Good.fur), new Material(0, Good.knife));
        addRecipe(Good.souvenir, false, new Material(50, Good.bone));
    }

    private void addRecipe(Good target, boolean needFire, Material ... materials) {
        Recipe recipe = new Recipe(target);
        recipe.setNeedFire(needFire);
        for(Material material : materials) {
            recipe.addMaterial(material);
        }
        recipeMap.put(recipe.getTarget().getID(), recipe);
    }

    public Recipe getRecipe(Good target) {
        return recipeMap.get(target.getID());
    }

    public Map<String, Recipe> getRecipeMap() {
        return recipeMap;
    }
}