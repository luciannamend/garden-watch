package com.lucianna.gardenapi.service;

import com.lucianna.gardenapi.model.Sensor;
import com.lucianna.gardenapi.repository.SensorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SensorService {

    private final SensorRepository sensorRepository;

    public boolean existsById(Integer id) {
        return sensorRepository.existsById(id);
    }

    public Sensor save(Sensor sensor) {
        return sensorRepository.save(sensor);
    }

    public Sensor findById(Integer id) {
        return sensorRepository.findById(id).orElse(null);
    }

    public List<Sensor> findAll() {
        return sensorRepository.findAll();
    }

    public void deleteById(Integer id) {
        sensorRepository.deleteById(id);
    }
}
