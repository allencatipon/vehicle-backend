package com.example.demo.controller;

import com.example.demo.model.Vehicle;
import com.example.demo.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:3000/")
@RestController
@RequestMapping("/api")
public class VehicleController {
    @Autowired
    private VehicleRepository vehicleRepository;

    @GetMapping("/vehicle")
    public List<Vehicle> getVehicle(@RequestParam String searchBy,
                                    @RequestParam String searchValue,
                                    @RequestParam String action,
                                    @RequestParam Vehicle vehicle) {
        switch(action){
            case "add":
                saveVehicle(buildVehicle(vehicle));
            case "update":
                updateVehicle(vehicle);
            case "delete":
                vehicleRepository.deleteById(vehicle.getId());
            case "filter":
                switch (searchBy) {
                    case "all":
                        return vehicleRepository.findAll();
                    case "id":
                        return vehicleRepository.findAllById(Long.valueOf(searchValue));
                    case "variant":
                        return vehicleRepository.findAllByVariantIgnoreCase(searchValue);
                    case "brand":
                        return vehicleRepository.findAllByBrandIgnoreCase(searchValue);
                    case "color":
                        return vehicleRepository.findAllByColorIgnoreCase(
                                searchValue);
                    case "engineCapacity":
                        return vehicleRepository.findAllByEngineCapacity(Long.valueOf(searchValue));
                }
        }
        return Collections.emptyList();
    }

    private void updateVehicle(Vehicle vehicle) {
        Optional<Vehicle> vehicleToBeUpdatedOpt = vehicleRepository.findById(vehicle.getId());
        if(vehicleToBeUpdatedOpt.isPresent()){
            Vehicle vehicleToBeUpdated = vehicleToBeUpdatedOpt.get();
            vehicleToBeUpdated.setEngineCapacity(vehicle.getEngineCapacity());
            vehicleToBeUpdated.setBrand(vehicle.getBrand());
            vehicleToBeUpdated.setColor(vehicle.getColor());
            saveVehicle(vehicleToBeUpdated);
        }
    }

    private Vehicle buildVehicle(Vehicle vehicle) {
        return new Vehicle(vehicle.getVariant(), vehicle.getBrand(), vehicle.getColor(), vehicle.getEngineCapacity());
    }

    private void saveVehicle(Vehicle newVehicle) {
        vehicleRepository.save(newVehicle);
    }
}
