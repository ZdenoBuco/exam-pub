package com.example.exampub.repositories;

import com.example.exampub.models.Drink;
import org.springframework.data.repository.CrudRepository;

public interface DrinkRepo extends CrudRepository<Drink, Long> {
}
