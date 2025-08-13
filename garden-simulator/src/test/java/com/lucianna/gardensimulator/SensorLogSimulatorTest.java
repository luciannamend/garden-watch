package com.lucianna.gardensimulator;

import com.lucianna.gardensimulator.model.PlantDTO;
import com.lucianna.gardensimulator.model.SensorDTO;
import com.lucianna.gardensimulator.model.SensorLogDTO;
import com.lucianna.gardensimulator.sensorlog.SensorLogSimulator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import java.security.SecureRandom;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class SensorLogSimulatorTest {

    @Mock
    private RestTemplate restTemplate;

    private final SensorLogSimulator simulator = new SensorLogSimulator();

    private final SecureRandom secureRandom = new SecureRandom();

    @Test
    @DisplayName("Should build a log with correct datetime, sensor, and humidity within range")
    void testBuildSensorLogReturnsValidLog() {
        // Arrange
        PlantDTO plant = new PlantDTO();
        plant.setMinHumidity(10f);
        plant.setMaxHumidity(20f);

        SensorDTO sensor = new SensorDTO();
        sensor.setPlant(plant);

        //System.out.println("Before call get random: " + secureRandom.nextFloat());
        // Act
        SensorLogDTO log = simulator.buildSensorLog(sensor);

        //System.out.println("After call get random: " + secureRandom.nextFloat());

        // Assert
        assertNotNull(log);
        assertNotNull(log.getDateTime());
        assertEquals(sensor, log.getSensor());
        //System.out.println("Log Value  >>>>>>>> " + log.getValue());
        assertTrue(log.getValue() >= 10f && log.getValue() <= 20f);
    }

    @Test
    void testSimulateSensorLogWithEmptySensors() {
        // simulateSensorLog returns early if sensors list is empty.
        assertDoesNotThrow(simulator::simulateSensorLog); // nothing should happen — just verify no exception
    }

}
