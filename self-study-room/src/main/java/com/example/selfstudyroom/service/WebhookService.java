package com.example.selfstudyroom.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class WebhookService {
    @Value("${webhook.url:}")
    private String webhookUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public void sendEntryNotification(String userId, String location) {
        if (webhookUrl == null || webhookUrl.isEmpty()) {
            return;
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Map<String, String> body = new HashMap<>();
        body.put("userId", userId);
        body.put("location", location);
        body.put("timestamp", java.time.LocalDateTime.now().toString());
        HttpEntity<Map<String, String>> entity = new HttpEntity<>(body, headers);
        try {
            restTemplate.postForEntity(webhookUrl, entity, String.class);
        } catch (Exception e) {
            // log or ignore failures
        }
    }
}
