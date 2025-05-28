INSERT INTO plant (name, min_humidity, avg_humidity, max_humidity, fruit) VALUES ('Cherry tomato', 0.300, 0.500, 0.700, 1);
INSERT INTO plant (name, min_humidity, avg_humidity, max_humidity, fruit) VALUES ( 'Basil', 0.200, 0.500, 0.600, 0);
INSERT INTO plant (name, min_humidity, avg_humidity, max_humidity, fruit) VALUES ( 'Oregano', 0.400, 0.500, 0.700, 0);
INSERT INTO plant (name, min_humidity, avg_humidity, max_humidity, fruit) VALUES ( 'Thyme', 0.400, 0.600, 0.700, 0);

INSERT INTO sensor (name, type, plant_id) VALUES ('Cherry tomato sensor', 'HUMIDITY', (select id from plant where name = 'Cherry tomato'));
INSERT INTO sensor (name, type, plant_id) VALUES ('Basil sensor', 'HUMIDITY', (select id from plant where name = 'Basil'));
INSERT INTO sensor (name, type, plant_id) VALUES ('Oregano sensor', 'HUMIDITY', (select id from plant where name = 'Oregano'));
INSERT INTO sensor (name, type, plant_id) VALUES ('Thyme sensor', 'HUMIDITY', (select id from plant where name = 'Thyme'));
