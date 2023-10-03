package com.example.exampub.services;

import com.example.exampub.models.Drink;

public interface DrinkService {
    Iterable<Drink> findAllDrinks();
}
