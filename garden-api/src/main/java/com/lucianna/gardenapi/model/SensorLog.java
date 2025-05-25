package com.lucianna.gardenapi.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "sensor_log")
public class SensorLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "INTEGER", nullable = false)
    private Integer id;

    @ManyToOne(targetEntity = Sensor.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "sensor_id", nullable = false)
    private Sensor sensor;

    @Column(name = "value", columnDefinition = "DECIMAL(3,2)", scale = 3, precision = 2, nullable = false)
    private float value;

    @Column(name = "datetime", columnDefinition = "TIMESTAMP", nullable = false)
    private Instant dateTime;
}
