package com.sher.service;

import com.sher.dto.Food;
import com.sher.entity.Animal;
import com.sher.entity.Zoo;
import com.sher.event.ZooEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ZooServiceImpl implements ZooService {
    private static ApplicationEventPublisher publisher;
    private final Zoo zoo;

    @Autowired
    public ZooServiceImpl(Zoo zoo, ApplicationEventPublisher publisher) {
        this.zoo = zoo;
        this.publisher = publisher;
    }

    @Override
    public List<Animal> feed(Food food) {
        List<Animal> angryAnimals = new ArrayList<>();
        for (Animal animal : zoo.getAnimals()) {
            if (animal.isAngry()) {
                animal.eat(food);
            }
            if (animal.isAngry()) {
                angryAnimals.add(animal);
            }
        }
        System.out.println("angryAnimals: " + angryAnimals);
        // eventAngryAnimals(angryAnimals);
        return angryAnimals;
    }

    public void eventAngryAnimals(List<Animal> angryAnimals) {
        ZooEvent zooEvent = new ZooEvent(angryAnimals, "ALARM! There is angry animal in zoo");
        publisher.publishEvent(zooEvent);
    }
}
