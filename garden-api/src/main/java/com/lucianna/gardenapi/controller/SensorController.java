package com.lucianna.gardenapi.controller;

import com.lucianna.gardenapi.model.Plant;
import com.lucianna.gardenapi.model.Sensor;
import com.lucianna.gardenapi.service.SensorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/sensors")
public class SensorController {

    private final SensorService sensorService;

    @PostMapping
    public ResponseEntity<Sensor> save(@RequestBody Sensor sensor) {
        return ResponseEntity.ok().body(sensorService.save(sensor));
    }

    @GetMapping
    public ResponseEntity<List<Sensor>> findAll() {
        return ResponseEntity.ok().body(sensorService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Sensor> findById(@PathVariable int id) {
        Sensor sensor = sensorService.findById(id);
        return ResponseEntity.ok().body(sensor);
    }

    @PutMapping
    public ResponseEntity<Sensor> update(@RequestBody Sensor sensor) {
        if (!sensorService.existsById(sensor.getId())) {
            return ResponseEntity.notFound().build();
        }

        Sensor updatedSensor = sensorService.save(sensor);
        return ResponseEntity.ok().body(sensorService.save(updatedSensor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        if (!sensorService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        sensorService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
