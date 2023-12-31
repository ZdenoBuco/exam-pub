package com.example.exampub.repositories;

import com.example.exampub.models.Drink;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DrinkRepo extends CrudRepository<Drink, Long> {
}
