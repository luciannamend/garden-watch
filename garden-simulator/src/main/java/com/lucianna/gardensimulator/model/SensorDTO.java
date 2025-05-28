package com.lucianna.gardensimulator.model;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public class SensorDTO {
    private Integer id;
    private String name;
    private SensorType type;
    private PlantDTO plant;
}
