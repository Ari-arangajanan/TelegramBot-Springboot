package com.example.telegram.controller;

import com.example.telegram.service.TelegramWebHooks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

@RestController
@RequestMapping("/telegram")
public class TelegramController {
    @Value("${telegram.url}") // Assuming you have telegramUrl and webAppUrl as properties
    private String telegramUrl;

    @Value("${web.app.url}")
    private String webAppUrl;

    @Value("${telegram.bot.webhookPath}")
    private String webhookPath;

    private final TelegramWebHooks telegramBot;

    @Autowired
    public TelegramController(TelegramWebHooks telegramBot) {
        this.telegramBot = telegramBot;
    }

    @PostMapping("/setWebhook")
    public ResponseEntity<String> setWebhook() {
        String url = telegramUrl + "/setWebhook?url=" + webAppUrl;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity(webhookPath, null, String.class);

        if (response.getStatusCode().is2xxSuccessful()) return ResponseEntity.ok("WebHook setup is Successfully");
        else return ResponseEntity.status(response.getStatusCode()).body("failed to setup webhook");

        // You can handle the response as per your requirements
        // For example, checking response.getStatusCode() and returning an appropriate ResponseEntity.
        // For simplicity, let's return the response as is.
    }
    @PostMapping("/message")
    public BotApiMethod<?> message(@RequestBody Update update){
        return telegramBot.onWebhookUpdateReceived(update);
    }
}
