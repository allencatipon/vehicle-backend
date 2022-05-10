package com.example.demo.batch;

import com.example.demo.model.Vehicle;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Processor implements ItemProcessor<Vehicle, Vehicle> {

    private static final Map<String, String> DEPT_NAMES = new HashMap<>();

    //Sample Scenario: Transforming code to name
    public Processor(){
        DEPT_NAMES.put("001", "Technology");
        DEPT_NAMES.put("002", "Operations");
        DEPT_NAMES.put("003", "Accounts");
    }

    @Override
    public Vehicle process(Vehicle vehicle) throws Exception {
        String variant = vehicle.getVariant();
        String transformedVariant = DEPT_NAMES.get(variant);
        vehicle.setVariant(transformedVariant);
        System.out.println(String.format("Converted from [%s] to [%s]", variant, transformedVariant));
        return vehicle;
    }
}
