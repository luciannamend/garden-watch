package com.lucianna.gardenapi.controller;

import com.lucianna.gardenapi.AbstractControllerTest;
import com.lucianna.gardenapi.ApiPath;
import com.lucianna.gardenapi.builder.Plants;
import com.lucianna.gardenapi.model.Plant;
import com.lucianna.gardenapi.repository.PlantRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PlantControllerIT extends AbstractControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    public PlantRepository plantRepository;

    @Test
    public void given_plant_when_save_then_savePlant() {
        // Given
        final var plant = Plants.aPlant().id(null).build();

        // When
        ResponseEntity<Plant> response = restTemplate.postForEntity(ApiPath.PLANTS, plant, Plant.class);

        // Then
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        final var savedPlant = response.getBody();

        assertPlant(plant, savedPlant);

        final Plant existingPlant = plantRepository.findById(savedPlant.getId()).orElse(null);

        assertPlant(plant, existingPlant);
    }

    private void assertPlant(Plant expectedPlant, Plant actualPlant) {
        assertNotNull(actualPlant);
        assertEquals(expectedPlant.getName(), actualPlant.getName());
        assertEquals(expectedPlant.getMinHumidity(), actualPlant.getMinHumidity());
        assertEquals(expectedPlant.getAvgHumidity(), actualPlant.getAvgHumidity());
        assertEquals(expectedPlant.getMaxHumidity(), actualPlant.getMaxHumidity());
        assertEquals(expectedPlant.isFruit(), actualPlant.isFruit());
    }
}
