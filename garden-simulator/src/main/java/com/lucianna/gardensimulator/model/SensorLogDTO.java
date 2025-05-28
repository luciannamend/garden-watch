package com.lucianna.gardensimulator.model;

import lombok.*;

import java.time.Instant;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public class SensorLogDTO {

    private Integer id;
    private float value;
    private Instant dateTime;
    private SensorDTO sensor;
}
