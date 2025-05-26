package com.lucianna.gardenapi.controller;

import com.lucianna.gardenapi.model.Plant;
import com.lucianna.gardenapi.service.PlantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/plants")
public class PlantController {

    private final PlantService plantService;

    @PostMapping
    public ResponseEntity<Plant> save(@RequestBody Plant plant) {
        return ResponseEntity.ok().body(plantService.save(plant));
    }

    @GetMapping
    public ResponseEntity<List<Plant>> findAll() {
        return ResponseEntity.ok().body(plantService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Plant> findById(@PathVariable int id) {
        return ResponseEntity.ok().body(plantService.findById(id));
    }

    @PutMapping
    public ResponseEntity<Plant> update(@RequestBody Plant plant) {
        if (!plantService.existsById(plant.getId())) {
            return ResponseEntity.notFound().build();
        }

        Plant updatedPlant = plantService.save(plant);
        return ResponseEntity.ok().body(plantService.save(updatedPlant));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        if (!plantService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        plantService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
