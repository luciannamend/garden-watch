package com.lucianna.gardenapi.repository;

import com.lucianna.gardenapi.model.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Integer> {
}
