package com.lucianna.gardenapi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    // STOMP endpoints
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // endpoint que o websocket vai escutar todas as comunicações
        // change /chat to /websocket
        registry.addEndpoint("/chat").setAllowedOrigins("*");
        registry.addEndpoint("/chat").setAllowedOrigins("*").withSockJS();
    }

    // Config message broker options
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic"); // /plants -> /humidity
        registry.setApplicationDestinationPrefixes("/app"); // garden-watch
    }

}