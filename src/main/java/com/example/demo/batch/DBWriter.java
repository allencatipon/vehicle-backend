package com.example.demo.batch;

import com.example.demo.model.Vehicle;
import com.example.demo.repository.VehicleRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBWriter implements ItemWriter<Vehicle> {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public void write(List<? extends Vehicle> vehicles) throws Exception {
        System.out.println("Data Saved for Vehicles: " + vehicles);
        vehicleRepository.saveAll(vehicles);
    }
}
