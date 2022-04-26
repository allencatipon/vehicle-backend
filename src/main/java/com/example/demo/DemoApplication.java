package com.example.demo;

import com.example.demo.model.Vehicle;
import com.example.demo.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	private VehicleRepository vehicleRepository;

	@Override
	public void run(String...args) throws Exception {
		this.vehicleRepository.save(new Vehicle(VehicleEnum.CAR.variant, "Mitsubishi", "Black", 400L));
		this.vehicleRepository.save(new Vehicle(VehicleEnum.CAR.variant, "Chervolet", "Violet", 400L));
		this.vehicleRepository.save(new Vehicle(VehicleEnum.CAR.variant, "Honda", "Black", 400L));
		this.vehicleRepository.save(new Vehicle(VehicleEnum.MOTORCYCLE.variant,"Ducati", "Red", 1200L));
		this.vehicleRepository.save(new Vehicle(VehicleEnum.CAR.variant, "Aprilla", "Orange", 900L));
		this.vehicleRepository.save(new Vehicle(VehicleEnum.MOTORCYCLE.variant,"Kotse", "Red", 400L));
		this.vehicleRepository.save(new Vehicle(VehicleEnum.MOTORCYCLE.variant,"Samsung", "Black", 600L));
		this.vehicleRepository.save(new Vehicle(VehicleEnum.MOTORCYCLE.variant,"Cotsero", "Red", 300L));
		this.vehicleRepository.save(new Vehicle(VehicleEnum.CAR.variant, "Tsurigi", "Orange", 400L));
		this.vehicleRepository.save(new Vehicle(VehicleEnum.CAR.variant, "Jollibee", "Violet", 400L));
		this.vehicleRepository.save(new Vehicle(VehicleEnum.CAR.variant, "Mcdo", "Pink", 500L));
		this.vehicleRepository.save(new Vehicle(VehicleEnum.CAR.variant, "AngatBuhay", "Pink", 300L));
	}


}
