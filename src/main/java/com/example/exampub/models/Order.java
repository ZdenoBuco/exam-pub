package com.example.exampub.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "`order`")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private Integer Amount;
    private double price;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "drink_id", referencedColumnName = "id")
    private List<Drink> drinks;
}
