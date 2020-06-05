package com.sher.entity;

import com.sher.dto.FoodType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class Cat implements Animal {
    private boolean angry = true;

    public void voice() {
        System.out.println("mi");
    }

    @Override
    public boolean isAngry() {
        return angry;
    }

    public void setAngry(boolean angry) {
        this.angry = angry;
    }

    @Override
    public List<FoodType> getPossibleFeedTypes() {
        return new ArrayList<>(Arrays.asList(FoodType.MILK, FoodType.FISH));
    }
}
