package com.example.exampub.services;

import com.example.exampub.DTOs.UserDTO;
import com.example.exampub.models.Drink;

public interface DrinkService {
    Iterable<Drink> findAllDrinks();
}
