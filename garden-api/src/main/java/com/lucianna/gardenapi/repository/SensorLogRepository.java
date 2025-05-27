package com.lucianna.gardenapi.repository;

import com.lucianna.gardenapi.model.SensorLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorLogRepository extends JpaRepository<SensorLog, Integer> {
}
