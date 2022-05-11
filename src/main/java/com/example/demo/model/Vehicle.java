package com.example.demo.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String variant;
    @NotNull
    private String brand;
    @NotNull
    private String color;
    @NotNull
    private Long engineCapacity;

    @NotNull
    private Boolean isMigrated;

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", variant='" + variant + '\'' +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", engineCapacity=" + engineCapacity +
                ", isMigrated=" + isMigrated +
                '}';
    }
}
