package com.sher.event;

import com.sher.dto.Food;
import com.sher.dto.FoodType;
import com.sher.entity.Animal;
import com.sher.service.ZooServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    private final ZooServiceImpl zooService;

    @Autowired
    public EventService(ZooServiceImpl zooService) {
        this.zooService = zooService;
    }

    @EventListener(ZooEvent.class)
    public void onApplicationEvent(ZooEvent zooEvent) {
        List<Animal> angryAnimals = (List<Animal>) zooEvent.getSource();
        if (!angryAnimals.isEmpty()) {
            System.out.println(zooEvent.getMessage());
            FoodType[] foodTypes = FoodType.values();
            for (FoodType foodType : foodTypes) {
                Food food = new Food();
                food.setFoodType(foodType);
                angryAnimals = zooService.feed(food);
                if (angryAnimals.isEmpty()) {
                    break;
                }
            }
        }
    }
}
