ALTER TABLE plant
    ADD min_temperature   DECIMAL(4, 3) NOT NULL,
    ADD avg_temperature   DECIMAL(4, 3) NOT NULL,
    ADD max_temperature   DECIMAL(4, 3) NOT NULL,
    ADD min_soil_moisture DECIMAL(4, 3) NOT NULL,
    ADD avg_soil_moisture DECIMAL(4, 3) NOT NULL,
    ADD max_soil_moisture DECIMAL(4, 3) NOT NULL;
