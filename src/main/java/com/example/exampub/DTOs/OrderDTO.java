package com.example.exampub.DTOs;

import lombok.Data;

@Data
public class OrderDTO {
    private String productName;
    private Integer amount;
    private double price;
}
