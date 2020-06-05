package com.sher.service;

import com.sher.dto.Food;
import com.sher.entity.Animal;
import com.sher.entity.Zoo;
import com.sher.event.ZooEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class ZooServiceImpl implements ZooService {
    private final Zoo zoo;

    @Autowired
    public ZooServiceImpl(Zoo zoo) {
        this.zoo = zoo;
    }

    @Override
    public List<Animal> feed(Food food) {
        List<Animal> angryAnimals = new ArrayList<>();
        for (Animal animal : zoo.getAnimals()) {
            animal.eat(food);
            if (animal.isAngry()) {
                angryAnimals.add(animal);
            }
        }
        System.out.println(angryAnimals);
        return angryAnimals;
    }
}
