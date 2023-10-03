package com.example.exampub.controllres;

import com.example.exampub.DTOs.BuyDTO;
import com.example.exampub.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
public class OrderController {
    private final OrderService orderService;
    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @PostMapping("/buy")
    public ResponseEntity<?> buyOrderedItemsByUser(@RequestBody BuyDTO buyDTO) {
        try {
            orderService.buyOrderedItems(buyDTO);
            return ResponseEntity.ok().build();
        } catch (Exception exception) {
            return ResponseEntity.status(404).body(exception.getMessage());
        }
    }
}
