package com.sher;

import com.sher.configuration.AnnotationConfiguration;
import com.sher.dto.Food;
import com.sher.dto.FoodType;
import com.sher.entity.Animal;
import com.sher.event.ZooEvent;
import com.sher.service.ZooService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDateTime;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = getAnnotationContext();
        feedAnimal(context);
    }

    public static void feedAnimal(ApplicationContext context) {
        ZooService service = context.getBean(ZooService.class);
        Food food = new Food();
        food.setFoodType(FoodType.WORM);
        food.setExpirationDate(LocalDateTime.now().plusHours(6));
        List<Animal> angryAnimals = service.feed(food);
        eventAngryAnimals(context, angryAnimals);
    }

    private static void eventAngryAnimals(ApplicationContext context, List<Animal> angryAnimals) {
        ZooEvent zooEvent= new ZooEvent(angryAnimals,"ALARM! There is angry animal in zoo");
        context.publishEvent(zooEvent);
    }

    public static ApplicationContext getAnnotationContext() {
        return new AnnotationConfigApplicationContext(AnnotationConfiguration.class);
    }
}
