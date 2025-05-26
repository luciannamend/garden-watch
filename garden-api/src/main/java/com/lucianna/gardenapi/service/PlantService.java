package com.lucianna.gardenapi.service;

import com.lucianna.gardenapi.model.Plant;
import com.lucianna.gardenapi.repository.PlantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PlantService {

    private final PlantRepository plantRepository;

    public boolean existsById(Integer id) {
        return plantRepository.existsById(id);
    }

    public Plant save(Plant plant) {
        return plantRepository.save(plant);
    }

    public Plant findById(Integer id) {
        return plantRepository.findById(id).orElse(null);
    }

    public List<Plant> findAll() {
        return plantRepository.findAll();
    }

    public void deleteById(Integer id) {
        plantRepository.deleteById(id);
    }
}
