package com.example.demo.controller;

import com.example.demo.model.Vehicle;
import com.example.demo.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class VehicleController {
    @Autowired
    private VehicleRepository vehicleRepository;

    @GetMapping("/vehicle")
    public Page<Vehicle> get(@RequestParam String searchBy,
                             @RequestParam String searchValue,
                             Pageable pageable) {

        if (!ObjectUtils.isEmpty(searchValue)) {
            switch (searchBy) {
                case "id":
                    return this.vehicleRepository.findAllById(Integer.valueOf(searchValue), pageable);
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
                default:
                    return this.vehicleRepository.findAll(pageable);
            }
        }

        return this.vehicleRepository.findAll(pageable);
    }

    @DeleteMapping("/vehicle")
    public void delete(Vehicle vehicle) {
        this.vehicleRepository.deleteById(vehicle.getId());
    }

    @PostMapping("/vehicle")
    public void post(@RequestBody Vehicle vehicle) {
        saveVehicle(buildVehicle(vehicle));
    }

    private Vehicle buildVehicle(Vehicle vehicle) {
        return new Vehicle(vehicle.getVariant(), vehicle.getBrand(), vehicle.getColor(), vehicle.getEngineCapacity());
    }

    private void saveVehicle(Vehicle newVehicle) {
        vehicleRepository.save(newVehicle);
    }

    @PutMapping("/vehicle")
    private void put(@RequestParam String id, @RequestBody Vehicle vehicle) {
        Optional<Vehicle> retrievedVehicle = vehicleRepository.findById(Integer.valueOf(id));
        if (retrievedVehicle.isPresent()) {
            Vehicle vehicleToBeUpdated = retrievedVehicle.get();
            vehicleToBeUpdated.setEngineCapacity(vehicle.getEngineCapacity());
            vehicleToBeUpdated.setBrand(vehicle.getBrand());
            vehicleToBeUpdated.setColor(vehicle.getColor());
            saveVehicle(vehicleToBeUpdated);
        }
    }
}
