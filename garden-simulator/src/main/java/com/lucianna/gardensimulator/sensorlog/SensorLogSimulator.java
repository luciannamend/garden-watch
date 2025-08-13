package com.lucianna.gardensimulator.sensorlog;

import com.lucianna.gardensimulator.config.GardenApiUrl;
import com.lucianna.gardensimulator.model.PlantDTO;
import com.lucianna.gardensimulator.model.SensorDTO;
import com.lucianna.gardensimulator.model.SensorLogDTO;
import com.lucianna.gardensimulator.model.SensorType;
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

            if (sensors.isEmpty()) {
                throw new RuntimeException("No sensors found in the API %s check if `initial-data.sql` was executed in the DB".formatted(sensorsUrl));
            }

        } catch (Exception e) {
            log.error("Could not connect to the API {}, check immediately.", sensorsUrl);
            throw new RuntimeException(e.getMessage());
        }
    }

    @Scheduled(fixedRate = 50000)
    public void simulateSensorLog() {
        if (sensors.isEmpty()) {
            return;
        }

        try {
            for (SensorDTO sensor : sensors) {
                final ResponseEntity<SensorLogDTO> sensorLogDTO = restTemplate.postForEntity(GardenApiUrl.getSensorLogsUrl(), buildSensorLog(sensor), SensorLogDTO.class);

                if (sensorLogDTO.getStatusCode().isError()) {
                    log.error("Error posting sensor log: {}", sensorLogDTO.getStatusCode());
                }
            }
        } catch (Exception e) {
            log.error("Error posting sensor logs: {}", e.getMessage());
        }
    }

    public SensorLogDTO buildSensorLog(SensorDTO sensor) {
        final SensorType sensorType = sensor.getType();
        final PlantDTO plant = sensor.getPlant();

        final SensorLogDTO sensorLog = new SensorLogDTO();
        sensorLog.setDateTime(Instant.now());
        sensorLog.setSensor(sensor);
        sensorLog.setValue(getRandomValue(sensorType, plant));

        return sensorLog;
    }

    private float getRandomValue(SensorType sensorType, PlantDTO plant) {
        float min = 0;
        float max = 0;

        switch (sensorType) {
            case TEMPERATURE:
                min = plant.getMinTemperature();
                max = plant.getMaxTemperature();
                break;
            case HUMIDITY:
                min = plant.getMinHumidity();
                max = plant.getMaxHumidity();
                break;
            case SOIL_MOISTURE:
                min = plant.getMinSoilMoisture();
                max = plant.getMaxSoilMoisture();
                break;
            default:
                log.error("Sensor type {} not supported.", sensorType);
                throw new IllegalArgumentException("Sensor type not supported.");
        }

        return secureRandom.nextFloat(min, max);
    }
}