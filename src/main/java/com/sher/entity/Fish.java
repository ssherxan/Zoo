package com.sher.entity;

import com.sher.dto.FoodType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Fish implements Animal {
    private boolean angry = true;

    @Override
    public void voice() {
    }

    @Override
    public void setAngry(boolean angry) {
        this.angry = angry;
    }

    @Override
    public boolean isAngry() {
        return angry;
    }

    @Override
    public List<FoodType> getPossibleFeedTypes() {
        List<FoodType> foodType = new ArrayList<>();
        foodType.add(FoodType.WORM);
        return foodType;
    }
}
