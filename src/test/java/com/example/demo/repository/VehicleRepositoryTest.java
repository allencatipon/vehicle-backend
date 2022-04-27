package com.example.demo.repository;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.print.Pageable;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
class VehicleRepositoryTest {
    @Autowired
    private VehicleRepository vehicleRepository;

    @Test
    public void testFindAllById(){
        assertFalse(vehicleRepository.findAllById(1, PageRequest.of(0, 5)).isEmpty());
    }

    @Test
    public void testFindAllByVariant(){
        assertEquals(5,vehicleRepository.findAllByVariantIgnoreCase("Car", PageRequest.of(0, 5)).getSize());
    }

    @Test
    public void testFindAllByBrand(){
        assertEquals("Ducati",vehicleRepository.findAllByBrandIgnoreCase("ducati", PageRequest.of(0, 5)).stream().findFirst().get().getBrand());
    }

    @Test
    public void testFindAllByColor(){
        assertEquals("Red",vehicleRepository.findAllByColorIgnoreCase("rEd", PageRequest.of(0, 5)).stream().findFirst().get().getColor());
    }

    @Test
    public void testFindAllByEngineCapacity(){
        assertEquals(1200L,vehicleRepository.findAllByEngineCapacity(1200L, PageRequest.of(0, 5)).stream().findFirst().get().getEngineCapacity());
    }

    @Test
    public void testIdNotFound(){
        assertTrue(vehicleRepository.findAllById(333, PageRequest.of(0, 5)).isEmpty());
    }
}