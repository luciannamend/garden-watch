package com.lucianna.gardenapi.controller;

import com.lucianna.gardenapi.model.SensorLog;
import com.lucianna.gardenapi.service.SensorLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "${api.baseUrl}sensor-logs")
public class SensorLogController {
    private final SensorLogService sensorLogService;
    private final SimpMessagingTemplate messagingTemplate;


    @PostMapping
    public ResponseEntity<SensorLog> save(@RequestBody SensorLog sensorLog) {
        // TODO: Send a websocket message to the client to update the plant's status'
        final SensorLog savedSensorLog = sensorLogService.save(sensorLog);
        messagingTemplate.convertAndSend(
                "/topic/messages",
                "Sensor: " + sensorLog.getSensor().getName() + "Value: " + sensorLog.getValue()
        );

        return ResponseEntity.ok().body(savedSensorLog);
    }

    @GetMapping
    public ResponseEntity<List<SensorLog>> findAll() {
        return ResponseEntity.ok().body(sensorLogService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<SensorLog> findById(@PathVariable int id) {
        return ResponseEntity.ok().body(sensorLogService.findById(id));
    }

    @PutMapping
    public ResponseEntity<SensorLog> update(@RequestBody SensorLog sensorLog) {
        if (!sensorLogService.existsById(sensorLog.getId())) {
            return ResponseEntity.notFound().build();
        }

        SensorLog updatedSensorLog = sensorLogService.save(sensorLog);
        return ResponseEntity.ok().body(sensorLogService.save(updatedSensorLog));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        if (!sensorLogService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        sensorLogService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
