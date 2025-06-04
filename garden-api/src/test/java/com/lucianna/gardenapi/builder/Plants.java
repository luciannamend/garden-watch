package com.lucianna.gardenapi.builder;

import com.lucianna.gardenapi.model.Plant;

public class Plants {

    public static Plant.PlantBuilder aPlant() {
        return Plant.builder()
                .id(1)
                .name("Cherry Tomato")
                .minHumidity(0.2f)
                .avgHumidity(0.5f)
                .maxHumidity(0.8f)
                .fruit(true);
    }
}
