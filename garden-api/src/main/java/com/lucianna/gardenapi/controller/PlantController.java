package com.lucianna.gardenapi.controller;

import com.lucianna.gardenapi.model.Plant;
import com.lucianna.gardenapi.service.PlantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/plants")
public class PlantController {

    private final PlantService plantService;

    @PostMapping
    public ResponseEntity<Plant> save(@RequestBody Plant plant) {
        return ResponseEntity.ok().body(plantService.save(plant));
    }
}
