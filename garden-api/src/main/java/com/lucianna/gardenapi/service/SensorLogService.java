package com.lucianna.gardenapi.service;

import com.lucianna.gardenapi.model.SensorLog;
import com.lucianna.gardenapi.repository.SensorLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SensorLogService {

    private final SensorLogRepository sensorLogRepository;

    public boolean existsById(Integer id) {
        return sensorLogRepository.existsById(id);
    }

    public SensorLog save(SensorLog sensorLog) {
        return sensorLogRepository.save(sensorLog);
    }

    public SensorLog findById(Integer id) {
        return sensorLogRepository.findById(id).orElse(null);
    }

    public List<SensorLog> findAll() {
        return sensorLogRepository.findAll();
    }

    public void deleteById(Integer id) {
        sensorLogRepository.deleteById(id);
    }
}
