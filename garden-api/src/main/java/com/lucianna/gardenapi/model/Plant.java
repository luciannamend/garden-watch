package com.lucianna.gardenapi.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
@AllArgsConstructor
@Entity
@Table(name = "plant")
public class Plant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "INTEGER", nullable = false)
    private Integer id;

    @Column(name = "name", columnDefinition = "VARCHAR(100)", length = 100, nullable = false)
    private String name;

    @Column(name = "min_humidity", columnDefinition = "DECIMAL(3,2)", nullable = false)
    private Float minHumidity;

    @Column(name = "avg_humidity", columnDefinition = "DECIMAL(3,2)", nullable = false)
    private Float avgHumidity;

    @Column(name = "max_humidity", columnDefinition = "DECIMAL(3,2)", nullable = false)
    private Float maxHumidity;

    @Column(name = "fruit", columnDefinition = "BOOLEAN", nullable = false)
    private boolean fruit;
}
