package com.sher.aspect;

import com.sher.dto.Food;
import com.sher.dto.FoodType;
import com.sher.entity.Animal;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class AnimalAspect {

    @Pointcut(value = "execution(* com.sher.entity.Animal.eat(..))")
    public void eatPoint() {
    }

    @Around(value = "eatPoint() && args(food)")
    public Object checkingPossibleFeedTypes(ProceedingJoinPoint proceedingJoinPoint, Food food) {
        boolean result = false;

        Animal animal = (Animal) proceedingJoinPoint.getTarget();
        System.out.println("Check possible food: "
                + food.getFoodType() + " for: " + animal);

        List<FoodType> possibleFoodTypes = animal.getPossibleFeedTypes();

        if (possibleFoodTypes.contains(food.getFoodType())) {
            try {
                result = (boolean) proceedingJoinPoint.proceed();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
        return result;
    }
}
