package com.lucianna.gardenapi.model;

import lombok.*;

import java.time.Instant;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SensorLogWsMessage {
    private SensorType sensorType;
    private int plantId;
    private float value;
    private Instant dateTime;

}
