package com.example.exampub.controllres;

import com.example.exampub.services.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/drink-menu")
public class DrinkController {
    private final DrinkService drinkService;

    @Autowired
    public DrinkController(DrinkService drinkService) {
        this.drinkService = drinkService;
    }
    @GetMapping("")
    public ResponseEntity<?> findAllUsers() {
        try {
            return ResponseEntity.ok().body(drinkService.findAllDrinks());
        } catch (Exception exception) {
            return ResponseEntity.status(404).body(exception.getMessage());
        }
    }
}
