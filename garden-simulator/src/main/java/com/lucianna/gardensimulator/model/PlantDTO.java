package com.lucianna.gardensimulator.model;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public class PlantDTO {
    private Integer id;
    private String name;
    private float minHumidity;
    private float avgHumidity;
    private float maxHumidity;
    private float minTemperature;
    private float avgTemperature;
    private float maxTemperature;
    private float minSoilMoisture;
    private float avgSoilMoisture;
    private float maxSoilMoisture;
    private boolean fruit;
    private SensorDTO sensor;
}

