package com.example.telegram.config;

import com.example.telegram.service.TelegramWebHooks;
import com.example.telegram.service.interfaces.TelegramMethodService;
import com.example.telegram.service.TelegramMethodsImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TelegramConfig {
    @Bean
    public TelegramMethodService telegramMethodService() {
        return new TelegramMethodsImpl();
    }
}
