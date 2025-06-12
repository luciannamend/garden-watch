package com.lucianna.gardensimulator.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GardenApiUrl {
    private static String BASE_URL;

    private GardenApiUrl(@Value("${garden.api.url}") String baseUrl) {
        GardenApiUrl.BASE_URL = baseUrl;
    }

    public static String getSensorsUrl() {
        return BASE_URL + "sensors";
    }
    public static String getPlantsUrl() {
        return BASE_URL + "plants";
    }
    public static String getSensorLogsUrl() {
        return BASE_URL + "sensor-logs";
    }
}
