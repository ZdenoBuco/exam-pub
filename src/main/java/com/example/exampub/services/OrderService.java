package com.example.exampub.services;

import com.example.exampub.DTOs.BuyDTO;
import com.example.exampub.models.Drink;

public interface OrderService {
    void addDrinkIntoOrder(BuyDTO buyDTO);

}
