package com.lucianna.gardenapi.model;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum SensorType {
    TEMPERATURE,
    HUMIDITY,
    LIGHT_INTENSITY,
    SOIL_MOISTURE
}
