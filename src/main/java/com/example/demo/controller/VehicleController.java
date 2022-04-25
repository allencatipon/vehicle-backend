package com.example.demo.controller;

import com.example.demo.model.Vehicle;
import com.example.demo.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api")
public class VehicleController {
    @Autowired
    private VehicleRepository vehicleRepository;

    @GetMapping("/vehicle")
    public List<Vehicle> getVehicle(@RequestParam String searchBy,
                                    @RequestParam String searchValue) {
        if (!ObjectUtils.isEmpty(searchBy)) {
            if (!ObjectUtils.isEmpty(searchValue)) {
                switch (searchBy) {
                    case "id":
                        return this.vehicleRepository.findAllById(Long.valueOf(searchValue));
                    case "variant":
                        return this.vehicleRepository.findAllByVariantIgnoreCase(searchValue);
                    case "brand":
                        return this.vehicleRepository.findAllByBrandIgnoreCase(searchValue);
                    case "color":
                        return this.vehicleRepository.findAllByColorIgnoreCase(
                                searchValue);
                    case "engineCapacity":
                        return this.vehicleRepository.findAllByEngineCapacity(Long.valueOf(searchValue));
                }
            }
            return this.vehicleRepository.findAll();
        }
        return Collections.emptyList();
    }
}
