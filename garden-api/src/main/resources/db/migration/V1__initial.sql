CREATE SCHEMA IF NOT EXISTS garden_watch;

CREATE TABLE IF NOT EXISTS plant
(
    id           INTEGER PRIMARY KEY   NOT NULL AUTO_INCREMENT,
    name         VARCHAR(100)          NOT NULL,
    min_humidity DECIMAL(4, 3)         NOT NULL,
    avg_humidity DECIMAL(4, 3)         NOT NULL,
    max_humidity DECIMAL(4, 3)         NOT NULL,
    fruit        BOOLEAN DEFAULT FALSE NOT NULL
);

CREATE TABLE IF NOT EXISTS sensor
(
    id       INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name     VARCHAR(50),
    type     VARCHAR(20)         NOT NULL,
    plant_id INTEGER             NOT NULL,
    CONSTRAINT FK_sensor_plant_id FOREIGN KEY (plant_id) REFERENCES plant (id)
);

CREATE TABLE IF NOT EXISTS sensor_log
(
    id        INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
    value     DECIMAL(4, 3)       NOT NULL,
    datetime  TIMESTAMP           NOT NULL,
    sensor_id INTEGER             NOT NULL,
    CONSTRAINT FK_sensor_log_sensor_id FOREIGN KEY (sensor_id) REFERENCES sensor (id)
);
