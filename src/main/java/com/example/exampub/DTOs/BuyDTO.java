package com.example.exampub.DTOs;

import lombok.Data;

@Data
public class BuyDTO {
    private Long UserId;
    private Long ProductId;
    private double price;
}
