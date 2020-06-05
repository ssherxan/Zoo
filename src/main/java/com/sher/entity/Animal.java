package com.sher.entity;


import com.sher.dto.Food;
import com.sher.dto.FoodType;

import java.util.List;

public interface Animal {
    void voice();

    boolean isAngry();

    List<FoodType> getPossibleFeedTypes();

    default boolean eat(Food food) {
        List<FoodType> possibleFeedTypes = getPossibleFeedTypes();
        if (possibleFeedTypes.contains(food.getFoodName())) {
            setAngry(false);
        }
        return isAngry();
    }
    void setAngry(boolean angry);
}
