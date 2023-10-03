package com.example.exampub.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "`order`")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private Integer Amount;
    private double price;

    public Order(String productName, Integer amount, double price) {
        this.productName = productName;
        Amount = amount;
        this.price = price;
    }
}
