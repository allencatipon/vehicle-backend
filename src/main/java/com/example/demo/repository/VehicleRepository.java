package com.example.demo.repository;

import com.example.demo.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Long> {
    List<Vehicle> findAllById(Long id);
    List<Vehicle> findAllByVariantIgnoreCase(String variant);
    List<Vehicle> findAllByBrandIgnoreCase(String brand);
    List<Vehicle> findAllByColorIgnoreCase(String color);
    List<Vehicle> findAllByEngineCapacity(Long engineCapacity);

}
