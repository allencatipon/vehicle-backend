package com.example.demo.controller;

import com.example.demo.model.Vehicle;
import com.example.demo.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class VehicleController {
    @Autowired
    private VehicleRepository vehicleRepository;

    @GetMapping("/vehicle")
    public Page<Vehicle> getVehicle(@RequestParam String searchBy,
                                    @RequestParam String searchValue,
                                    Pageable pageable) {
        if (!ObjectUtils.isEmpty(searchBy)) {
            if (!ObjectUtils.isEmpty(searchValue)) {
                switch (searchBy) {
                    case "id":
                        return this.vehicleRepository.findAllById(Long.valueOf(searchValue), pageable);
                    case "variant":
                        return this.vehicleRepository.findAllByVariantIgnoreCase(searchValue, pageable);
                    case "brand":
                        return this.vehicleRepository.findAllByBrandIgnoreCase(searchValue, pageable);
                    case "color":
                        return this.vehicleRepository.findAllByColorIgnoreCase(
                                searchValue, pageable);
                    case "engineCapacity":
                        return this.vehicleRepository.findAllByEngineCapacity(Long.valueOf(searchValue),
                                pageable);
                }
            }
            return this.vehicleRepository.findAll(pageable);
        }
        return this.vehicleRepository.findAll(pageable);
    }
}
