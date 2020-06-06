package com.sher.entity;


import com.sher.dto.Food;
import com.sher.dto.FoodType;

import java.util.List;

public interface Animal {
    void voice();

    boolean isAngry();

    void setAngry(boolean angry);

    List<FoodType> getPossibleFeedTypes();

    default boolean eat(Food food) {
        System.out.println(this + " are eating " + food.getFoodType());
        if(isAngry()){
            setAngry(false);
        }
        return true;
    }
}
