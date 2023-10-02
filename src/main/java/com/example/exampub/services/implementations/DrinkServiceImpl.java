package com.example.exampub.services.implementations;

import com.example.exampub.models.Drink;
import com.example.exampub.repositories.DrinkRepo;
import com.example.exampub.repositories.UserRepo;
import com.example.exampub.services.DrinkService;
import org.springframework.stereotype.Service;

@Service
public class DrinkServiceImpl implements DrinkService {
    private final DrinkRepo drinkRepo;

    public DrinkServiceImpl(DrinkRepo drinkRepo) {
        this.drinkRepo = drinkRepo;
    }
    @Override
    public Iterable<Drink> findAllDrinks() {
        return drinkRepo.findAll();
    }
}
