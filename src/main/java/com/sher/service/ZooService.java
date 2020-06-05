package com.sher.service;

import com.sher.dto.Food;
import com.sher.entity.Animal;

import java.util.List;

public interface ZooService {
    List<Animal> feed(Food food);
}
