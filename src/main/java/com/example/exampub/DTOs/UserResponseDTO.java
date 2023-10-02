package com.example.exampub.DTOs;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class UserResponseDTO {
    private Long id;
    private String name;
    private boolean isActive;
    private LocalDate dateOfBirth;
    private Double pocket;
    private List<OrderDTO> orders;
}

