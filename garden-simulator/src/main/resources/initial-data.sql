DELETE FROM sensor_log;
DELETE FROM sensor;
DELETE FROM plant;

INSERT INTO plant (name, min_humidity, avg_humidity, max_humidity, min_temperature, avg_temperature, max_temperature, min_soil_moisture, avg_soil_moisture, max_soil_moisture, fruit)
VALUES ('Cherry tomato', 0.300, 0.500, 0.700, 0.300, 0.500, 0.700, 0.300, 0.500, 0.700, 1);

INSERT INTO plant (name, min_humidity, avg_humidity, max_humidity, min_temperature, avg_temperature, max_temperature, min_soil_moisture, avg_soil_moisture, max_soil_moisture, fruit)
VALUES ( 'Basil', 0.200, 0.500, 0.600, 0.200, 0.500, 0.600,0.200, 0.500, 0.600,0);

INSERT INTO plant (name, min_humidity, avg_humidity, max_humidity, min_temperature, avg_temperature, max_temperature, min_soil_moisture, avg_soil_moisture, max_soil_moisture, fruit)
VALUES ( 'Oregano', 0.400, 0.500, 0.700, 0.400, 0.500, 0.700,0.400, 0.500, 0.700,0);

INSERT INTO plant (name, min_humidity, avg_humidity, max_humidity, min_temperature, avg_temperature, max_temperature, min_soil_moisture, avg_soil_moisture, max_soil_moisture, fruit)
VALUES ( 'Thyme', 0.400, 0.600, 0.700, 0.400, 0.600, 0.700, 0.400, 0.600, 0.700, 0);

INSERT INTO sensor (name, type, plant_id) VALUES ('Cherry tomato sensor', 'HUMIDITY', (select id from plant where name = 'Cherry tomato'));
INSERT INTO sensor (name, type, plant_id) VALUES ('Basil sensor', 'HUMIDITY', (select id from plant where name = 'Basil'));
INSERT INTO sensor (name, type, plant_id) VALUES ('Oregano sensor', 'HUMIDITY', (select id from plant where name = 'Oregano'));
INSERT INTO sensor (name, type, plant_id) VALUES ('Thyme sensor', 'HUMIDITY', (select id from plant where name = 'Thyme'));

INSERT INTO sensor (name, type, plant_id) VALUES ('Cherry tomato sensor', 'TEMPERATURE', (select id from plant where name = 'Cherry tomato'));
INSERT INTO sensor (name, type, plant_id) VALUES ('Basil sensor', 'TEMPERATURE', (select id from plant where name = 'Basil'));
INSERT INTO sensor (name, type, plant_id) VALUES ('Oregano sensor', 'TEMPERATURE', (select id from plant where name = 'Oregano'));
INSERT INTO sensor (name, type, plant_id) VALUES ('Thyme sensor', 'TEMPERATURE', (select id from plant where name = 'Thyme'));

INSERT INTO sensor (name, type, plant_id) VALUES ('Cherry tomato sensor', 'SOIL_MOISTURE', (select id from plant where name = 'Cherry tomato'));
INSERT INTO sensor (name, type, plant_id) VALUES ('Basil sensor', 'SOIL_MOISTURE', (select id from plant where name = 'Basil'));
INSERT INTO sensor (name, type, plant_id) VALUES ('Oregano sensor', 'SOIL_MOISTURE', (select id from plant where name = 'Oregano'));
INSERT INTO sensor (name, type, plant_id) VALUES ('Thyme sensor', 'SOIL_MOISTURE', (select id from plant where name = 'Thyme'));
