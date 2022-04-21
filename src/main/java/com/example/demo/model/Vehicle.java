package com.example.demo.model;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String variant;
    @NotNull
    private String brand;
    @NotNull
    private String color;
    @NotNull
    private Long engineCapacity;

    public Vehicle(){
    }
    public Vehicle(String variant, String brand, String color, Long engineCapacity) {
        this.variant = variant;
        this.brand = brand;
        this.color = color;
        this.engineCapacity = engineCapacity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Long getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(Long engineCapacity) {
        this.engineCapacity = engineCapacity;
    }
}
