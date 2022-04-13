package com.example.demo.repository;

import com.example.demo.model.Motorcycle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Motorcycle,Long> {
}
