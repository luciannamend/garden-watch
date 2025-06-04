package com.lucianna.gardenapi.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucianna.gardenapi.builder.Plants;
import com.lucianna.gardenapi.model.Plant;
import com.lucianna.gardenapi.service.PlantService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PlantController.class)
public class PlantControllerUnitTests {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private PlantService plantService;

    @Test
    public void given_nonExistingPlant_when_delete_then_returnNotFound() throws Exception {
        final int nonExistingPlantId = 1;
        when(plantService.existsById(eq(nonExistingPlantId))).thenReturn(false);

        mockMvc.perform(delete("/api/v1/plants/" + nonExistingPlantId)).andExpect(status().isNotFound());
    }

    @Test
    public void given_nonExistingPlant_when_update_then_returnNotFound() throws Exception {
        final Plant nonExistingPlant = Plants.aPlant().build();
        when(plantService.existsById(eq(nonExistingPlant.getId()))).thenReturn(false);

        mockMvc.perform(put("/api/v1/plants/").contentType(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(nonExistingPlant))).andExpect(status().isNotFound());
    }
}
