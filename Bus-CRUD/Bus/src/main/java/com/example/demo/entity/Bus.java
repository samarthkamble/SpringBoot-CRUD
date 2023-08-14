package com.example.demo.entity;

import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String busName;
    private String destination;
    private String busType;
    private LocalTime departureTime;
    private LocalTime arrivalTime;
    private int totalSeat;
    private double price;

    // Constructors, getters, setters...
}
