package com.example.demo.repository;

import com.example.demo.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Long> {
    List<Vehicle> findAllById(Long id);
    List<Vehicle> findAllByVariant(String variant);
    List<Vehicle> findAllByBrand(String brand);
    List<Vehicle> findAllByColor(String color);
    List<Vehicle> findAllByEngineCapacity(Long engineCapacity);

}
