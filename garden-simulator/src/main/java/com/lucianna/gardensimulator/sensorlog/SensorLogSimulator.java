package com.lucianna.gardensimulator.sensorlog;

import com.lucianna.gardensimulator.config.GardenApiUrl;
import com.lucianna.gardensimulator.model.*;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.security.SecureRandom;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class SensorLogSimulator {

    private final List<SensorDTO> sensors = new ArrayList<>();
    private final RestTemplate restTemplate;
    private final SecureRandom secureRandom;

    public SensorLogSimulator() {
        this.restTemplate = new RestTemplate();
        this.secureRandom = new SecureRandom();
    }

    @PostConstruct
    public void init() {
        secureRandom.setSeed(Instant.now().toEpochMilli());

        final var sensorsUrl = GardenApiUrl.getSensorsUrl();

        try {
            SensorDTO[] response = restTemplate.getForObject(sensorsUrl, SensorDTO[].class);

            if (response != null) {
                sensors.addAll(Arrays.asList(response));
            }

        } catch (Exception e) {
            log.error("Could not connect to the API {}, check immediately.", sensorsUrl);
            throw new RuntimeException(e.getMessage());
        }
    }

    @Scheduled(fixedRate = 10000)
    public void simulateSensorLog() {
        if (sensors.isEmpty()) {
            return;
        }

        for (SensorDTO sensor : sensors) {
            final ResponseEntity<SensorLogDTO> sensorLogDTO = restTemplate.postForEntity(GardenApiUrl.getSensorLogsUrl(),
                    buildSensorLog(sensor), SensorLogDTO.class);

            if (sensorLogDTO.getStatusCode().isError()) {
                log.warn("Error posting sensor log: {}", sensorLogDTO.getStatusCode());
            }
        }
    }

    public SensorLogDTO buildSensorLog(SensorDTO sensor) {
        final SensorLogDTO sensorLog = new SensorLogDTO();
        sensorLog.setDateTime(Instant.now());
        sensorLog.setSensor(sensor);

        final PlantDTO plant = sensor.getPlant();
        final float randomValue = getRandomValue(plant.getMinHumidity(), plant.getMaxHumidity());
        sensorLog.setValue(randomValue);
        return sensorLog;
    }

    private float getRandomValue(float min, float max) {
        return secureRandom.nextFloat(min, max);
    }
}