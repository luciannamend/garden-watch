package com.lucianna.gardenapi.controller;

import com.lucianna.gardenapi.config.ApiPath;
import com.lucianna.gardenapi.model.SensorLog;
import com.lucianna.gardenapi.service.SensorLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(ApiPath.SENSOR_LOGS)
public class SensorLogController {
    private final SensorLogService sensorLogService;

    @PostMapping
    public ResponseEntity<SensorLog> save(@RequestBody SensorLog sensorLog) {
        return ResponseEntity.ok().body(sensorLogService.save(sensorLog));
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
