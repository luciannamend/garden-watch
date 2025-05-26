package com.lucianna.gardenapi.service;

import com.lucianna.gardenapi.model.Plant;
import com.lucianna.gardenapi.repository.PlantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PlantService {

    private final PlantRepository plantRepository;

    public Plant save(Plant plant) {
        if (plant.getMaxHumidity() < 0) {
            throw new IllegalArgumentException("Max humidity cannot be less than 0");
        }
        if (plant.getMaxHumidity() > 100) {
            throw new IllegalArgumentException("Max humidity cannot be greater than 100");
        }
        
        return plantRepository.save(plant);
    }
}
