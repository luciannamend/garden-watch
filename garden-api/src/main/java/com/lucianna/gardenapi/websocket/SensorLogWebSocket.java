package com.lucianna.gardenapi.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;

public class SensorLogWebSocket {

    @MessageMapping("/app/chat")
    @SendTo("/topic/messages")
    public String sendCurrentHumidity(Float currentHumidity) {
        return "Current humidity ";
    }

}
