package com.example.demo.repository;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@RunWith(SpringRunner.class)
@DataJpaTest
class VehicleRepositoryTest {
    @Autowired
    private VehicleRepository vehicleRepository;

    @Test
    public void testFindAll(){
        assertFalse(vehicleRepository.findAll().isEmpty());
    }

    @Test
    public void testFindAllById(){
        Long id = 1L;
        assertFalse(vehicleRepository.findAllById(id).isEmpty());
    }

    @Test
    public void testFindAllByVariant(){
        assertEquals(2,vehicleRepository.findAllByVariant("Car").size());
    }

    @Test
    public void testFindAllByBrand(){
        assertEquals("Ducati",vehicleRepository.findAllByBrand("Ducati").stream().findFirst().get().getBrand());
    }

    @Test
    public void testFindAllByColor(){
        assertEquals("Red",vehicleRepository.findAllByColor("Red").stream().findFirst().get().getColor());
    }

    @Test
    public void testFindAllByEngineCapacity(){
        assertEquals(1200L,vehicleRepository.findAllByEngineCapacity(1200L).stream().findFirst().get().getEngineCapacity());
    }
}