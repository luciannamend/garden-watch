package com.lucianna.gardenapi.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class SensorLogWebSocket {

    @MessageMapping("/events/notifications")
    @SendTo("/topic/sensor-logs")
    public String sendCurrentHumidity(Float currentHumidity) {
        return "Current humidity " + currentHumidity;
    }

}
