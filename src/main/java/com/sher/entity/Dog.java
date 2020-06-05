package com.sher.entity;

import com.sher.dto.FoodType;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

@Component
@Scope(value = SCOPE_PROTOTYPE)
public class Dog implements Animal {
    private boolean angry = true;

    public void voice() {

        System.out.println("gav");
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
        foodType.add(FoodType.MEAT);
        return foodType;
    }
}
