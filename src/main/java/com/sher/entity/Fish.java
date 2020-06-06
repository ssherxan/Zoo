package com.sher.entity;

import com.sher.dto.FoodType;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Fish implements Animal {
    private boolean angry = true;

    @Override
    public void voice() {
        System.out.println("bul bul");
    }

    @Override
    public boolean isAngry() {
        return angry;
    }

    @Override
    public void setAngry(boolean angry) {
        this.angry = angry;
    }

    @Override
    public List<FoodType> getPossibleFeedTypes() {
        return List.of(FoodType.WORM);
    }
}
